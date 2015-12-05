package fr.bretzel.mysql.api;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by MrBretzel on 03/12/2015.
 */
public enum DataType {

    VARCHAR(String.class, "VARCHAR"),
    CHAR(String.class, "CHAR"),
    LONG_VARCHAR(String.class, "LONG_VARCHAR"),
    BIT(Boolean.TYPE, "BIT"),
    NUMERIC(BigDecimal.class, "NUMERIC"),
    TINYINT(Byte.TYPE, "TINYINT"),
    SMALLINT(Short.TYPE, "SMALLINT"),
    INTEGER(Integer.TYPE, "INTEGER"),
    BIGINT(Long.TYPE, "BIGINT"),
    REAL(Float.TYPE, "REAL"),
    FLOAT(Float.TYPE, "FLOAT"),
    DOUBLE(Double.TYPE, "DOUBLE"),
    VARBINARY(Byte.TYPE, "VARBINARY"),
    BINARY(Byte.TYPE, "BINARY"),
    DATE(Date.class, "DATE"),
    TIME(Time.class, "TIME"),
    TIMESTAMP(Timestamp.class, "TIMESTAMP"),
    CLOB(Clob.class, "CLOB"),
    BLOB(Blob.class, "BLOB"),
    ARRAY(Array.class, "ARRAY"),
    REF(Ref.class, "REF"),
    STRUCT(Struct.class, "STRUCT"),
    SQLXML(SQLXML.class, "SQLXML");

    private Class<?> returnType;
    private String disName;
    private int option = -100;
    private boolean notNull;

    DataType(Class<?> returnType, String disName) {
        this(returnType, disName, -100);
    }

    DataType(Class<?> returnType, String disName, int option) {
        this.returnType = returnType;
        this.disName = disName;
        this.option = option;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public String getParameterName() {
        return disName;
    }

    public int getOption() {
        return option;
    }

    public boolean hasOption() {
        return option != -100;
    }

    public void setOption(int option) {
        if (hasOption())
            this.option = option;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }
}
