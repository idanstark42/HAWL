package control;

import model.classes.Class;
import model.members.Member;
import model.profilers.Profiler;
import model.profilers.control.UserAbilityProfiler;
import model.profilers.model.ModelProfiler;
import util.Queries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

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

    private List<Profiler>[] organizeProfilers(Profiler[] profilersArray){
        List<Profiler> profilers = Arrays.asList(profilersArray);
        //Control profilers
        Iterable<Profiler> controlProfilers = new Queries<>(profilers).where(profiler -> !(profiler instanceof ModelProfiler));
        List<Profiler> userAbilityProfilers = new LinkedList<>(), systemActionProfilers = new LinkedList<>();
        controlProfilers.forEach(controlProfiler -> {
            List controlProfilersList = (controlProfiler instanceof UserAbilityProfiler) ? userAbilityProfilers : systemActionProfilers;
            controlProfilersList.add(controlProfiler);
            profilers.remove(controlProfiler);
        });
        //Model profilers
        Iterable<Iterable<Profiler>> modelProfilers = new Queries<>(profilers).group(profiler -> ((ModelProfiler)profiler).getModel());
        //Adding it all into an array and returning the result
        ArrayList<List<Profiler>> result = new ArrayList<>();
        result.add(userAbilityProfilers);
        result.add(systemActionProfilers);
        modelProfilers.forEach(modelProfilersList -> result.add((List)modelProfilersList));
        return result.toArray(new List[result.size()]);
    }
}