package game.model;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.PreparedBatch;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;

import java.util.List;

public class DataBase {

    public static Jdbi createTabel(Jdbi jdbi){
        jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.setSqlLogger(new Slf4JSqlLogger());
        try(Handle handle = jdbi.open()){
            handle.execute("""
                    CREATE TABLE scoreboard(
                        id IDENTITY PRIMARY KEY ,
                        playerone VARCHAR,
                        playertwo VARCHAR,
                        winner VARCHAR 
                    )
                """);

            //uploadTabelTestElement(handle);
            //List<DataModel> check = handle.createQuery("SELECT * FROM scoreboard").mapToBean(DataModel.class).list();
            //check.forEach(System.out::println);

        }
        return jdbi;
    }


    public static void uploadTabelTestElement(Handle handle){
        PreparedBatch batch = handle.prepareBatch("INSERT INTO scoreboard(playerone,playertwo,winner) VALUES (:playerone,:playertwo,:winner)");
        batch.bindBean( new DataModel("Elek","Géza","Elek")).add();
        batch.bindBean( new DataModel("MZ/X","Tomi","Tomi")).add();
        batch.bindBean( new DataModel("SxC3","sade","SxC3")).add();
        batch.execute();
    }

    public static List<DataModel> getScoreBoard(Handle handle){
        List<DataModel> scores = handle.createQuery("SELECT * FROM scoreboard").mapToBean(DataModel.class).list();

        return scores;
    }





}
