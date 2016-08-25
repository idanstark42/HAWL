package model.members;

import java.lang.reflect.Type;

/**
 * Created by Idan Stark on 08/07/16.
 */
public class Member {

    private int modifier;
    private String name;
    private Type type;

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
