package fr.bretzel.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MrBretzel on 23/11/2015.
 */
public class SQL {

    private Connection connection;
    private String table;

    public SQL(Connection connection, String table) {
        this.connection = connection;
        this.table = table;
        try {
            this.connection.getStatement().execute(String.format(Util.CREATE_TABLE_IF_NOT_EXIST, table));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String request) {
        ResultSet result = null;
        try {
            result = connection.getStatement().executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean contains(String value) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(String.format(Util.SELECT_ALL_FROM_TABLE_WHERE_KEY, table, value));
            boolean result = statement.executeQuery().next();
            statement.close();
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTable() {
        return table;
    }

    public Connection getConnection() {
        return connection;
    }
}
