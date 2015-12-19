package fr.bretzel.mysql;

import fr.bretzel.mysql.api.DataBaseType;

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
    private DataBaseType type = DataBaseType.SQLite;
    private boolean connected = false;

    private boolean local = false;
    private int port = 3306;
    private String host;
    private String user;
    private String pass;

    public Connection(File db, DataBaseType type) {
        local = true;
        if (db == null)
            throw new IllegalArgumentException("The file cant not be null !");

        if (type == null)
            throw new IllegalArgumentException("The DataBaseType cant not be null !");

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

    public Connection(String host, String user, String pass, int port, String table, DataBaseType type) {
        this.type = type;
        this.db = table;
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
    }

    public synchronized void connect() {
        connected = true;
        if (local) localConnect();
        else serverConnect();
    }

    public synchronized void close() {
        try {
            connected = false;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private synchronized void localConnect() {
        try {
            Class.forName(type.getDriver()).newInstance();
            connection = DriverManager.getConnection("jdbc:" + type.getType() + ":" + db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void serverConnect() {
        try {
            Class.forName(type.getDriver()).newInstance();
            connection = DriverManager.getConnection("jdbc:" + type.getType() + "://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement createStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        return connected;
    }
}
