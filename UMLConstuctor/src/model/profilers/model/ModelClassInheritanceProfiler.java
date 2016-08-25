package model.profilers.model;

import model.classes.Class;
import model.members.Method;
import model.profilers.Profiler;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class ModelClassInheritanceProfiler extends ModelProfiler {

    private Class parent;

    public Class getParent() {
        return parent;
    }

    public void setParent(Class parent) {
        this.parent = parent;
    }

    @Override
    public void change(Class clazz) {
        clazz.setParent(parent);
    }

}
