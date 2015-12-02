package fr.bretzel.mysql.parameter;

import fr.bretzel.mysql.api.ITable;
import fr.bretzel.mysql.api.executable.IExecutableUpdate;
import fr.bretzel.mysql.api.parameters.IParameter;
import fr.bretzel.mysql.api.parameters.ITableParameter;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;

/**
 * Created by MrBretzel on 02/12/2015.
 */
public class TableParameter implements ITableParameter {

    private ITable table = null;
    private boolean build = false;

    private IExecutableUpdate executableUpdate;

    private LinkedList<ITableParameter> list = new LinkedList<>();

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public void setTable(ITable table) {
        this.table = table;
    }

    @Override
    public boolean isBuild() {
        return (table == null) && build;
    }

    @Override
    public void build() {
        build = true;
        if (getParameters().length < 0)
            return;

    }

    public IParameter add(ITableParameter parameter) {
        list.add(parameter);
        return this;
    }

    @Override
    @Deprecated
    public IParameter add(IParameter parameter) {
        list.add((ITableParameter) parameter);
        return this;
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    public void remove(ITableParameter parameter) {
        remove(indexOf(parameter));
    }

    @Override
    @Deprecated
    public void remove(IParameter parameter) {
        remove(indexOf(parameter));
    }

    @Override
    public int indexOf(IParameter parameter) {
        return list.indexOf(parameter);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public IParameter[] getParameters() {
        return (IParameter[]) list.toArray();
    }

    @Override
    public IExecutableUpdate getExecutableUpdate() {
        return executableUpdate;
    }

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
}
