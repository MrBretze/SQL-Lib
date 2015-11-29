package fr.bretzel.mysql.executable;

import fr.bretzel.mysql.api.executable.IExecutableUpdate;
import fr.bretzel.mysql.api.parameters.IParameterUpdate;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public class ExecutableUpdate implements IExecutableUpdate {

    private String query;
    private IParameterUpdate parameter;

    public ExecutableUpdate(String query, IParameterUpdate parameter) {
        this.query = query;
        this.parameter = parameter;
    }

    @Override
    public String get() {
        return query;
    }

    @Override
    public IParameterUpdate getParameter() {
        return parameter;
    }
}
