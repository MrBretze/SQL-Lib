package fr.bretzel.mysql;

import fr.bretzel.mysql.api.ITable;
import fr.bretzel.mysql.api.executable.IExecutableUpdate;
import fr.bretzel.mysql.api.parameters.ITableParameter;

/**
 * Created by MrBretzel on 02/12/2015.
 */
public class Table implements ITable {

    private ITableParameter parameter;

    public Table(ITableParameter parameter) {
        this.parameter = parameter;
        if (!parameter.isBuild())
            parameter.build();
    }

    @Override
    public ITableParameter getParameter() {
        return parameter;
    }

    @Override
    public IExecutableUpdate getExecutableUpdate() {
        return parameter.getExecutableUpdate();
    }
}
