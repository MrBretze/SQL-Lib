package fr.bretzel.mysql.api;

/**
 * Created by loicn on 05/12/2015.
 */
public enum DataBaseType {

    MySQL("mysql", "org.sqlite.JDBC"),
    SQLite("sqlite", "org.sqlite.JDBC");

    private String type;
    private String driver;

    DataBaseType(String data, String driver) {
        type = data;
        this.driver = driver;
    }

    public String getType() {
        return type;
    }

    public String getDriver() {
        return driver;
    }
}
