package control;

import model.classes.Class;
import model.profilers.Profiler;

import java.util.List;

/**
 * Created by Idan Stark on 30/07/16.
 */
public class ClassConstructor {

    public Class constructClass(List<Profiler> profilers){
        final Class clazz = new Class();
        profilers.forEach(profiler -> { profiler.change(clazz); });
        return clazz;
    }

}