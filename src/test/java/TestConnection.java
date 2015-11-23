import fr.bretzel.mysql.Connection;
import fr.bretzel.mysql.SQL;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by MrBretzel on 23/11/2015.
 */
public class TestConnection {

    @Test
    public void connect() {
        Connection connection = new Connection(new File("src/test/resources/database/connection.db"));
        connection.connect();
        connection.close();
    }

    @Test
    public void sqlContain() {
        Connection connection = new Connection(new File("src/test/resources/database/sqlContains.db"));
        connection.connect();
        SQL sql = new SQL(connection, "sql");
        sql.contains("test");
        Assert.assertEquals(sql.contains("test"), false);
        connection.close();
    }
}
