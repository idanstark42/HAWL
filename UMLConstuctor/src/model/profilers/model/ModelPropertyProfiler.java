package model.profilers.model;

import model.classes.Class;
import model.members.Field;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class ModelPropertyProfiler extends ModelProfiler {

    private Field property;

    public Field getProperty() {
        return property;
    }

    public void setProperty(Field property) {
        this.property = property;
    }

    @Override
    public void change(Class clazz) {
        clazz.getMembers().add(property);
    }

}
