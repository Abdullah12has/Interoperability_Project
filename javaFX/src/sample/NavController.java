package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavController implements Initializable {




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void updateScreen(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("update.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();

    }

    public void deleteScreen(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("delete.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();
    }

    public void postScreen(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("post.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();
    }


    public void getScreen(ActionEvent actionEvent) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("get.scene.fxml"));
        Scene updateScene = new Scene(viewParent);

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(updateScene);
        window.show();
    }
}











































































































