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
import model.Speaker;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class PostController implements Initializable {

    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtContents;
    @FXML
    private ComboBox cbType;
    @FXML
    private TextField txtPublish;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox cbPosition;
    @FXML
    private Label lbl;

    public void addLectureAction(ActionEvent actionEvent) {

        RestTemplate restTemplate = new RestTemplate();


        String restEndPointURL = "http://localhost:8083/api/lecture";

        Lecture lecture = new Lecture();
        Speaker speaker = new Speaker();
        lecture.setTitle(txtTitle.getText());
        lecture.setContents(txtContents.getText());
        lecture.setType((Lecture.Type) cbType.getValue());
        speaker.setName(txtName.getText());
        speaker.setPosition((Speaker.Position) cbPosition.getValue());
        lecture.setSpeaker(speaker);

        if (txtPublish.getText().equals("1")){
            lecture.setPublish(true);
        }
        else {
            lecture.setPublish(false);
        }

        restTemplate.postForObject(restEndPointURL, lecture , Lecture.class);

//reset and submit message
        txtTitle.setText("");
        txtContents.setText("");
       cbType.setValue("");
        txtPublish.setText("");
      txtDate.setText("");
       txtName.setText("");
       cbPosition.setValue("");
        lbl.setText("Submitted!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbType.setItems(FXCollections.observableArrayList( Lecture.Type.values()));
        cbPosition.setItems(FXCollections.observableArrayList( Speaker.Position.values()));
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("nav.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();

    }
}
