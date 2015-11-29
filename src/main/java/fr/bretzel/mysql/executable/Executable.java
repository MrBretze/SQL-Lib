package fr.bretzel.mysql.executable;

import fr.bretzel.mysql.api.executable.IExecutable;

/**
 * Created by MrBretzel on 28/11/2015.
 */
public class Executable implements IExecutable {

    private String update;

    public Executable(String str) {
        this.update = str;
    }

    @Override
    public String get() {
        return update;
    }
}
