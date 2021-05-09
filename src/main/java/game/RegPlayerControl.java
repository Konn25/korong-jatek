package game;

import java.io.IOException;


import game.model.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;


public class RegPlayerControl {

    @FXML
    TextField redPlayerName,bluePlayerName;

    @FXML
    Label errorText;

    private Stage stage;
    private Scene scene;
    private Parent root;

    String red;
    String blue;

    public static Jdbi jd;

    public void login(ActionEvent event) throws IOException {

        jd = Jdbi.create("jdbc:h2:mem:test");
        jd.setSqlLogger(new Slf4JSqlLogger());

        red = redPlayerName.getText();
        blue = bluePlayerName.getText();

        if(bluePlayerName.getText().length()==0 && redPlayerName.getText().length()==0){
            errorText.setText("A nevek megadása kötelező");
        }

        if(bluePlayerName.getText().length()>0 && redPlayerName.getText().length()==0){
            errorText.setText("Piros játékos neve nincs megadva");
        }else if(bluePlayerName.getText().length()==0 && redPlayerName.getText().length()>0){
            errorText.setText("Kék játékos neve nincs megadva");
        }

        if(bluePlayerName.getText().length()>0 && redPlayerName.getText().length()>0){

            if(bluePlayerName.getText().equals(redPlayerName.getText()) || redPlayerName.getText().equals(bluePlayerName.getText())){
                errorText.setText("A két játékos neve nem lehet egyforma");
            }else {
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
    }
}
