package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class DeleteController implements Initializable {
    @FXML
    private TextField txtId;



    public void onDeleteAction(ActionEvent actionEvent) {
        final String uri = "http://localhost:8083/api/lecture/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Long> params = new HashMap<>();
        long out = Long.parseLong(txtId.getText());
        System.out.println(out);
        params.put("id", out);

            restTemplate.delete ( uri,  params );

        txtId.setText("Deleted!");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("nav.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();

    }
}
