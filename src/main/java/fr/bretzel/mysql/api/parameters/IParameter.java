package fr.bretzel.mysql.api.parameters;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public interface IParameter {

    IParameter add(IParameter parameter);

    void remove(int index);

    void remove(IParameter parameter);

    int indexOf(IParameter parameter);

    int size();

    IParameter[] getParameters();

    boolean isBuild();

    void build();
}
