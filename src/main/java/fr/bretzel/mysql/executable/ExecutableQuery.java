package fr.bretzel.mysql.executable;

import fr.bretzel.mysql.api.executable.IExecutableQuery;
import fr.bretzel.mysql.api.parameters.IParameterQuery;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public class ExecutableQuery implements IExecutableQuery {

    private String query;
    private IParameterQuery parameter;

    public  ExecutableQuery(String s, IParameterQuery parameter) {
        this.query = s;
        this.parameter = parameter;
    }

    @Override
    public String get() {
        return query;
    }

    @Override
    public IParameterQuery getParameter() {
        return parameter;
    }
}
