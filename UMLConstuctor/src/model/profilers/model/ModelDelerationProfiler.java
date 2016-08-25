package model.profilers.model;

import model.classes.Class;
import model.members.Method;
import model.profilers.Profiler;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class ModelDelerationProfiler extends ModelProfiler {

    private int modifiers;

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public void change(Class clazz) {
        clazz.setName(getModel());
        clazz.setModifiers(modifiers);
    }

}
