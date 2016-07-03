package model;

/**
 * Created by Idan Stark on 03/07/16.
 */
public abstract class Action {

    private String name;

    public Action(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Iterable<Token> getTokens();
}
