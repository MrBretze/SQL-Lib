package fr.bretzel.mysql.parameter;

import fr.bretzel.mysql.api.ITable;
import fr.bretzel.mysql.api.parameters.IParameter;
import fr.bretzel.mysql.api.parameters.ITableParameter;

import java.util.LinkedList;

/**
 * Created by MrBretzel on 02/12/2015.
 */
public class TableParameter implements ITableParameter {

    private ITable table = null;
    private boolean build = false;

    private LinkedList<IParameter> list = new LinkedList<>();

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

    }

    @Override
    public IParameter add(IParameter parameter) {
        list.add(parameter);
        return this;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(IParameter parameter) {

    }

    @Override
    public int indexOf(IParameter parameter) {
        return 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public IParameter[] getParameters() {
        return new IParameter[0];
    }
}
