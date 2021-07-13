package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Lecture;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class UpdateController implements Initializable {
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtContents;
    @FXML
    private ComboBox cbTypes;
    @FXML
    private ComboBox cbLectures;
    @FXML
    private Label lbl;

    private List<Lecture> store = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getLecturesId();
        cbTypes.setItems(FXCollections.observableArrayList( Lecture.Type.values()));
    }

    private void getLecturesId() {

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.ALL);

        converter.setSupportedMediaTypes(mediaTypes);
        messageConverters.add(converter);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);

        String restEndPointURL = "http://localhost:8083/api/lecture";

        ResponseEntity<Lecture[]> lectureArrayResponse = restTemplate.getForEntity(restEndPointURL, Lecture[].class);

        for (Lecture lecture : lectureArrayResponse.getBody()){
            cbLectures.getItems().add(lecture.getId());
            store.add(lecture);
        }

    }

    public void onUpdate(ActionEvent actionEvent) {

        RestTemplate restTemplate = new RestTemplate();

        String restEndPointURL = "http://localhost:8083/api/lecture/{id}";

        Map<String, Long> params = new HashMap<String, Long>();

        params.put("id", (Long) cbLectures.getValue());

        Lecture previous = restTemplate.getForObject(restEndPointURL, Lecture.class, params);

        Lecture updatedLecture = new Lecture(previous.getId(), txtTitle.getText(), (Lecture.Type) cbTypes.getValue(), txtContents.getText(), previous.isPublish(), previous.getCreatedAt());

        restTemplate.put ( restEndPointURL, updatedLecture, params );
        lbl.setText("Lecture no "+updatedLecture.getId()+ " has been updated");
    }

    public void chooseId(ActionEvent actionEvent) {
        for (Lecture lec : store) {
            if (lec.getId().equals(cbLectures.getValue())){ txtTitle.setText(lec.getTitle());
                txtContents.setText(lec.getContents());
                cbTypes.setValue(lec.getType());

                lbl.setText(" ");
            }
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("nav.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();

    }
}
