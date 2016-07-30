package control;

import model.classes.Class;
import model.profilers.Profiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class UmlConstructor {

    private ClassConstructor classConstructor;

    public List<Class> generateUML(Profiler[] profilers){
        List<Class> uml = new ArrayList<>();
        for(List<Profiler> profilerGroup : organizeProfilers(profilers)) {
            uml.add(classConstructor.constructClass(profilerGroup));
        }
        return uml;
    }

    private List<Profiler>[] organizeProfilers(Profiler[] profilers){
        
    }

}
