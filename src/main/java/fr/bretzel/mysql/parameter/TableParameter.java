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

    private LinkedList<ITableParameter> list = new LinkedList<>();

    public TableParameter(ITableParameter... tableParameters) {
        for (ITableParameter parameter: tableParameters) {
            list.add(parameter);
        }
    }

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
}
