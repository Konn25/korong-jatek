package game.results;

import com.github.javafaker.Faker;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.PreparedBatch;

import java.util.List;

/**
 * Create a table in the database, upload and get results.
 */

public class DataBase {

    /**
     * Creat a table.
     *
     * @param jdbi where store the jdbi
     */
    public static void createTabel(Jdbi jdbi) {
        try (Handle handle = jdbi.open()) {
            handle.execute("""
                        CREATE TABLE scoreboard(
                            id IDENTITY PRIMARY KEY ,
                            playerone VARCHAR,
                            playertwo VARCHAR,
                            winner VARCHAR 
                        )
                    """);

        }
    }


    /**
     * Upload the table with random elements for testing.
     *
     * @param handle
     */
    public static void uploadTableTestElement(Handle handle) {
        Faker faker = new Faker();
        String testuser = faker.name().lastName();
        String testuser2 = faker.name().lastName();
        String testuser3 = faker.name().lastName();
        PreparedBatch batch = handle.prepareBatch("INSERT INTO scoreboard(playerone,playertwo,winner) VALUES (:playerone,:playertwo,:winner)");
        batch.bindBean(new DataModel(testuser, faker.name().username(), testuser)).add();
        batch.bindBean(new DataModel(faker.name().username(), testuser2, testuser2)).add();
        batch.bindBean(new DataModel(testuser3, faker.name().username(), testuser3)).add();
        batch.execute();
    }

    /**
     * Get data from table.
     *
     * @param handle
     * @return data from table
     */
    public static List<DataModel> getScoreBoard(Handle handle) {

        return handle.createQuery("SELECT playerone,playertwo,winner FROM scoreboard").mapToBean(DataModel.class).list();
    }

    /**
     * Upload new players and winner to the table
     *
     * @param jdbi       a database
     * @param redplayer  red player name
     * @param blueplayer blue player name
     * @param winner     winner name
     */

    public static void uploadResultToDataBase(Jdbi jdbi, String redplayer, String blueplayer, String winner) {
        try (Handle handle = jdbi.open()) {
            PreparedBatch batch = handle.prepareBatch("INSERT INTO scoreboard(playerone,playertwo,winner) VALUES (:playerone,:playertwo,:winner)");
            batch.bindBean(new DataModel(redplayer, blueplayer, winner)).add();
            batch.execute();
        }

    }


}
