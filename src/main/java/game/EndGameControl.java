package game;

import game.model.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class EndGameControl {

    @FXML
    Label winnerLabel;

   @FXML
   TextArea scoreTextArea;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String bluePlayer="";
    private String redPlayer="";

    public void setWinner(String win){
        winnerLabel.setText("Győztes: "+win);
    }

    public void getPlayer(String red,String blue){
        redPlayer=red;
        bluePlayer=blue;
    }

    public void setScoreBoard(List<DataModel> list){

        String text = scoreTextArea.getText();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            scoreTextArea.setText(text+"\n"+list.get(i).getPlayerone()+" "+list.get(i).getPlayertwo()+" "+list.get(i).getWinner());

            text = scoreTextArea.getText();
            System.out.println("TEXT : "+text);
        }

    }

    public void newGame(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/regplayer.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Új játék");
        stage.setScene(scene);
        stage.show();
    }

    public void reMatch(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/game.fxml"));
        root = loader.load();
        DrawBoard dr = loader.getController();
        dr.setBlueName(bluePlayer);
        dr.setRedName(redPlayer);


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Piros játékos: "+redPlayer+"  Kék játékos: "+bluePlayer);
        stage.show();
    }




}
