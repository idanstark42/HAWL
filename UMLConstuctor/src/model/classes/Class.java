package model.classes;

import model.members.Member;

import java.util.List;

/**
 * Created by Idan Stark on 29/07/16.
 */
public class Class {

    private int modifiers;
    private String name;
    private Class parent;
    private List<Interface> abilities;
    private List<Member> members;

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Interface> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Interface> abilities) {
        this.abilities = abilities;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Class getParent() {
        return parent;
    }

    public void setParent(Class parent) {
        this.parent = parent;
    }
}
