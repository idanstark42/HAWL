package model.profilers.control;

import model.classes.Class;
import model.members.Method;
import model.profilers.Profiler;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class SystemActionProfiler extends Profiler {

    private Method ability;

    public Method getAbility() {
        return ability;
    }

    public void setAbility(Method ability) {
        this.ability = ability;
    }

    @Override
    public void change(Class clazz) {
        clazz.getMembers().add(ability);
    }

}
