package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan Stark on 03/07/16.
 */
public class Token extends Action{

    public static final String DESCRIPTION_SEPARATOR = ":";

    private String specifications;

    public Token(String description) {
        super(description.split(DESCRIPTION_SEPARATOR)[0]);
        this.specifications = description.split(DESCRIPTION_SEPARATOR)[1];
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Override
    public Iterable<Token> getTokens() {
        List<Token> result = new ArrayList<>();
        result.add(this);
        return result;
    }

    public String toString(){
        StringBuilder bob = new StringBuilder();
        bob.append(getName());
        bob.append(DESCRIPTION_SEPARATOR);
        bob.append(specifications);
        return bob.toString();
    }

}
