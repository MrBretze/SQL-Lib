package fr.bretzel.mysql.api;

/**
 * Created by loicn on 05/12/2015.
 */
public enum DataBaseType {
    MySQL("mysql"),
    SQLite("sqlite");

    private String type;

    DataBaseType(String data) {
        type = data;
    }

    public String getType() {
        return type;
    }
}
