package model.profilers.model;

import model.classes.Class;
import model.classes.Interface;
import model.members.Field;
import model.members.Method;
import model.profilers.Profiler;

import java.util.Collection;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class ModelAbilityProfiler extends ModelProfiler {

    private Interface ability;
    private Collection<Field> implementation;

    public Interface getAbility() {
        return ability;
    }

    public void setAbility(Interface ability) {
        this.ability = ability;
    }

    public Collection<Field> getImplementation() {
        return implementation;
    }

    public void setImplementation(Collection<Field> implementation) {
        this.implementation = implementation;
    }

    @Override
    public void change(Class clazz) {
        clazz.getAbilities().add(ability);
        clazz.getMembers().addAll(implementation);
    }

}
