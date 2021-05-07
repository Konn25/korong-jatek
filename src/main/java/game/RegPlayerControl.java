package game;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegPlayerControl {

    @FXML
    TextField redPlayerName,bluePlayerName;

    private Stage stage;
    private Scene scene;
    private Parent root;

    String red;
    String blue;


    public void login(ActionEvent event) throws IOException {

        red = redPlayerName.getText();
        blue = bluePlayerName.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/game.fxml"));
        root = loader.load();
        DrawBoard dr = loader.getController();
        dr.setBlueName(blue);
        dr.setRedName(red);


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Piros játékos: " + red + "  Kék játékos: " + blue);
        stage.show();
    }
}
