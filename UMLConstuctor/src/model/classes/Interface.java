package model.classes;

import model.members.Member;

import java.util.List;

/**
 * Created by Idan Stark on 29/07/16.
 */
public class Interface{

    private Interface parent;
    private List<Member> members;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Interface getParent() {
        return parent;
    }

    public void setParent(Interface parent) {
        this.parent = parent;
    }
}
