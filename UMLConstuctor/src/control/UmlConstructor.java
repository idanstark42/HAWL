package control;

import model.classes.Class;
import model.profilers.Profiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class UmlConstructor {

    public List<Class> generateUML(Profiler[] profilers){
        List<Class> uml = new ArrayList<>();
        for(List<Profiler> profilerGroup : organizeProfilers(profilers)) {
            uml.add(constructClass(profilerGroup));
        }
        return uml;
    }

    private Class constructClass(List<Profiler> profilers){
        final Class clazz = new Class();
        profilers.forEach(profiler -> { profiler.change(clazz); });
        return clazz;
    }

    private List<Profiler>[] organizeProfilers(Profiler[] profilers){
        return null;
    }

}
