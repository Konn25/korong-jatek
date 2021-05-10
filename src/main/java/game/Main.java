package game;

import game.model.DataBase;
import javafx.application.Application;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Slf4JSqlLogger;

public class Main {

    public static Jdbi jd;
    public static void main(String[] args) {

        jd = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        jd.setSqlLogger(new Slf4JSqlLogger());

        try(Handle handle = jd.open()){
            DataBase.createTabel(Main.jd);
            DataBase.uploadTabelTestElement(handle);
        }

        Application.launch(GameApplication.class,args );


    }
}
