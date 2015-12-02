package fr.bretzel.mysql;

import fr.bretzel.mysql.api.ITable;
import fr.bretzel.mysql.api.executable.IExecutable;
import fr.bretzel.mysql.api.executable.IExecutableQuery;
import fr.bretzel.mysql.api.executable.IExecutableUpdate;
import fr.bretzel.mysql.api.parameters.ITableParameter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MrBretzel on 23/11/2015.
 */
public class SQL {

    private Connection connection;
    private ITable table;

    public SQL(Connection connection, ITableParameter table) {
        this.connection = connection;
        table.build();
        this.table = new Table(table);
    }

    public ResultSet executeQuery(IExecutableQuery query) {
        ResultSet result;
        try {
            result = connection.getStatement().executeQuery(query.get());
            return result;
        } catch (SQLException e) {
            System.out.print(e.getLocalizedMessage());
            return null;
        }
    }

    public void execute(IExecutable executable) {
        try {
            if (executable instanceof IExecutableQuery)
                executeQuery((IExecutableQuery) executable);
            else if (executable instanceof IExecutableUpdate)
                executeUpdate((IExecutableUpdate) executable);
            connection.getStatement().execute(executable.get());
            return;
        } catch (SQLException e) {
            System.out.print(e.getLocalizedMessage());
            return;
        }
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

    public boolean executeUpdate(IExecutableUpdate update) {
        try {
            PreparedStatement statement = connection.getConnection().prepareStatement(update.get());
            statement.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    public ITable getTable() {
        return table;
    }

    public Connection getConnection() {
        return connection;
    }
}
