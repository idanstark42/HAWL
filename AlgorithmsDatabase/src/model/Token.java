package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan Stark on 03/07/16.
 */
public class Token extends Action{

    public Token(String name) {
        super(name);
    }

    @Override
    public Iterable<Token> getTokens() {
        List<Token> result = new ArrayList<>();
        result.add(this);
        return result;
    }

}
