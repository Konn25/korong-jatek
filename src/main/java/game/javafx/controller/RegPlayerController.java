package game.javafx.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegPlayerController {

    @FXML
    TextField redPlayerName, bluePlayerName;

    @FXML
    Label errorText;

    private Stage stage;
    private Scene scene;
    private Parent root;

    String red;
    String blue;


    public void login(ActionEvent event) throws IOException {

        red = redPlayerName.getText();
        blue = bluePlayerName.getText();

        if (bluePlayerName.getText().length() == 0 && redPlayerName.getText().length() == 0) {
            errorText.setText("Names are required!!");
        }

        if (bluePlayerName.getText().length() > 0 && redPlayerName.getText().length() == 0) {
            errorText.setText("The name of the Red Player is not specified!!");
        } else if (bluePlayerName.getText().length() == 0 && redPlayerName.getText().length() > 0) {
            errorText.setText("The name of the Blue Player is not specified!!");
        }

        if (bluePlayerName.getText().length() > 0 && redPlayerName.getText().length() > 0) {

            if (bluePlayerName.getText().equals(redPlayerName.getText()) || redPlayerName.getText().equals(bluePlayerName.getText())) {
                errorText.setText("The names of the two players can't be the same");
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/game.fxml"));
                root = loader.load();
                DrawBoardController dr = loader.getController();
                dr.setBlueName(blue);
                dr.setRedName(red);


                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Red Player: " + red + "  Blue Player: " + blue);
                stage.show();
            }
        }
    }
}
