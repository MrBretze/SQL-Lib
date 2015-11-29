package fr.bretzel.mysql.api.executable;

import fr.bretzel.mysql.api.parameters.IParameterQuery;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public interface IExecutableQuery extends IExecutable {

    IParameterQuery getParameter();

}
