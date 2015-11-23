package fr.bretzel.mysql;

/**
 * Created by MrBretzel on 23/11/2015.
 */
public class Util {

    public static String CREATE_TABLE_IF_NOT_EXIST = "CREATE TABLE IF NOT EXISTS %s";
    public static String SELECT_ALL_FROM_TABLE_WHERE_KEY = "SELECT * FROM '%s' WHERE %s=?";
}
