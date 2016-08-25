package model.profilers.model;

import model.profilers.Profiler;

/**
 * Created by Idan Stark on 08/08/16.
 */
public abstract class ModelProfiler extends Profiler{

    private String model;

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

}
