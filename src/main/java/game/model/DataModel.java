package game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataModel {

    /*
        Player one is the red player
     */
    private String playerone;

    /*
        Player two is the blue player
     */
    private String playertwo;

    /*
        Player who win the game
     */
    private String winner;

}
