package fr.bretzel.mysql.api;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by MrBretzel on 03/12/2015.
 */
public enum DataType {

    VARCHAR(String.class),
    CHAR(String.class),
    LONG_VARCHAR(String.class),
    BIT(Boolean.class),
    NUMERIC(BigDecimal.class),
    TINYINT(Byte.TYPE),
    SMALLINT(Short.TYPE),
    INTEGER(Integer.TYPE),
    BIGINT(Long.TYPE),
    REAL(Float.TYPE),
    FLOAT(Float.TYPE),
    DOUBLE(Double.TYPE),
    VARBINARY(Byte.TYPE),
    BINARY(Byte.TYPE),
    DATE(Date.class),
    TIME(Time.class),
    TIMESTAMP(Timestamp.class),
    CLOB(Clob.class),
    BLOB(Blob.class),
    ARRAY(Array.class),
    REF(Ref.class),
    STRUCT(Struct.class),
    SQLXML(SQLXML.class);

    private Class<?> returnType;

    DataType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Class<?> getReturnType() {
        return returnType;
    }
}
