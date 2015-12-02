package fr.bretzel.mysql.api;

import fr.bretzel.mysql.api.executable.IExecutableUpdate;
import fr.bretzel.mysql.api.parameters.ITableParameter;

/**
 * Created by MrBretzel on 29/11/2015.
 */
public interface ITable {

    ITableParameter getParameter();

    IExecutableUpdate getExecutableUpdate();

}
