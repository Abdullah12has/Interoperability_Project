package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Lecture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class GetController implements Initializable {

    @FXML
    private TextArea outputArea;

    @FXML private TextField txtId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void findById(ActionEvent actionEvent) {

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
            if(lecture.getId().toString().equalsIgnoreCase(txtId.getText())){

                outputArea.setText(lecture.toString());
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

    public void getAll(ActionEvent actionEvent) {

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

        String all = " ";
        for (Lecture lecture : lectureArrayResponse.getBody()){
            all += lecture.toString();
            all += "\n";
        }
        outputArea.setText(all);


    }
}
