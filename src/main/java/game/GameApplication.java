package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends Application {

    /*
        * Start the game
     */

    @Override
    public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/regplayer.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Játék");
            stage.show();

    }
}
