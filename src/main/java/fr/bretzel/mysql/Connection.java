package fr.bretzel.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MrBretzel on 30/08/2015.
 */
public class Connection {

    private String db = "null";
    private java.sql.Connection connection = null;
    private Statement statement = null;

    public Connection(File db) {
        if (db == null)
            throw new IllegalArgumentException("The database is set to null !");

        if (!db.exists()) {
            db.getParentFile().mkdir();
            try {
                db.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.db = db.getAbsolutePath();
    }

    public Connection(String host, String user, String s) {
        //TODO
    }

    public synchronized void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + db);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
