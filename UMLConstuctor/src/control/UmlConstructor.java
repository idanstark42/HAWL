package control;

import model.classes.Class;
import model.profilers.Profiler;
import model.profilers.control.UserAbilityProfiler;
import model.profilers.model.ModelProfiler;
import util.Queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        profilers.forEach(profiler -> profiler.change(clazz));
        return clazz;
    }

    private List<Profiler>[] organizeProfilers(Profiler[] profilers){
        Iterable<Profiler> controlProfilers =
                new Queries<>(Arrays.asList(profilers))
                        .where(profiler -> !(profiler instanceof ModelProfiler));

        List<Profiler> UserAbilityProfilers = new LinkedList<>(), SystemActionProfilers = new LinkedList<>();
        controlProfilers.forEach(controlProfiler -> {
            List compatibleControlProfilersList =
                    (controlProfiler instanceof UserAbilityProfiler) ? UserAbilityProfilers : SystemActionProfilers;
            compatibleControlProfilersList.add(controlProfiler);
            //TODO delete item from profilers... change profilers to list?
        });

        return null;//TODO change to return the array of profilers list: each list for a class
                    // two for controllers and the rest for model.
    }
}