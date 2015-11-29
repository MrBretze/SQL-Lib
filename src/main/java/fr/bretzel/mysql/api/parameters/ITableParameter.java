package fr.bretzel.mysql.api.parameters;

import fr.bretzel.mysql.api.ITable;

/**
 * Created by MrBretzel on 29/11/2015.
 */
public interface ITableParameter extends IParameter {

    ITable getTable();

}
