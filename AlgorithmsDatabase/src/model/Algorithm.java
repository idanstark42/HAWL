package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan Stark on 02/07/16.
 */
public class Algorithm extends Action{

    private ArrayList<Action> actions;

    public Algorithm(String name){
        super(name);
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    @Override
    public Iterable<Token> getTokens() {
        List<Token> tokens = new ArrayList<>();
        for(Action action: this.actions){
            for(Token token : action.getTokens()) {
                tokens.add(token);
            }
        }
        return tokens;
    }
}
