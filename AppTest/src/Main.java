import mysql.Connection;
import mysql.SQL;

import java.io.File;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("test/");
        if (file.exists()) {
            for (File f : file.listFiles())
                f.delete();
        }
        Connection connection = new Connection(new File("test/test.db"));
        connection.connect();
        SQL sql = new SQL(connection, "TEST");
    }

}
