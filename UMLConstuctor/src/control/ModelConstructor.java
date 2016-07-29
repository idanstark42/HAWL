package control;

import model.profilers.Profiler;

/**
 * Created by Idan Stark on 29/07/16.
 */
public interface ModelConstructor {

    Class constructModelClass(Profiler[] profilers);

}
