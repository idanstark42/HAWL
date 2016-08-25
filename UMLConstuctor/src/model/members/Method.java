package model.members;

import model.Action;

/**
 * Created by Idan Stark on 08/07/16.
 */
public class Method extends Member{

    private Action function;

    public Action getFunction() {
        return function;
    }

    public void setFunction(Action function) {
        this.function = function;
    }
}
