package fr.bretzel.mysql;

import fr.bretzel.mysql.api.executable.IExecutableQuery;

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

    public ResultSet executeQuery(IExecutableQuery query) {
        ResultSet result = null;
        try {
            result = connection.getStatement().executeQuery(query.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean contains(String value) {
        try {
            String prepare = String.format(Util.SELECT_ALL_FROM_TABLE_WHERE_KEY, table, value);
            System.out.print(prepare);
            PreparedStatement statement = connection.getConnection().prepareStatement(prepare);
            boolean result = statement.executeQuery().next();
            statement.close();
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateFor(String column, String value, String columnFor, String idFor) {
        try {
            String prepare = String.format(Util.UPDATE_TABLE_SET_FOR_COLUMN, table, column, value, columnFor, idFor);
            System.out.print(prepare);
            PreparedStatement statement = connection.getConnection().prepareStatement(prepare);
            statement.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
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
