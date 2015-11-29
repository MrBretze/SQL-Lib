package fr.bretzel.mysql.api.executable;

import fr.bretzel.mysql.api.parameters.IParameterUpdate;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public interface IExecutableUpdate extends IExecutable {

    IParameterUpdate getParameter();

}
