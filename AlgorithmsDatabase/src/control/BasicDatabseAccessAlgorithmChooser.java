package control;

import data_access.Database;
import model.Algorithm;
import model.AlgorithmFamily;
import util.Queries;

/**
 * Created by Idan Stark on 03/07/16.
 */
public class BasicDatabseAccessAlgorithmChooser implements AlgorithmChooser{

    private Database algorithmsDatabase;

    public BasicDatabseAccessAlgorithmChooser(Database algorithmsDatabase){
        this.algorithmsDatabase = algorithmsDatabase;
    }

    public Database getAlgorithmsDatabase() {
        return algorithmsDatabase;
    }

    public void setAlgorithmsDatabase(Database algorithmsDatabase) {
        this.algorithmsDatabase = algorithmsDatabase;
    }

    @Override
    public Algorithm chooseAlgorithm(String description) {
        String[] split = description.split(" ");
        if(split.length == 1){
            AlgorithmFamily family = new Queries<>(algorithmsDatabase.getAllAlgorithemFamilies())
                    .qwhere(f -> f.getName().equals(description)).first();
            return new Queries<>(algorithmsDatabase.getAlgorithmsInFamily(family)).first();
        }
        AlgorithmFamily family = new Queries<>(algorithmsDatabase.getAllAlgorithemFamilies())
                .qwhere(f -> f.getName().equals(split[0])).first();
        return new Queries<>(algorithmsDatabase.getAlgorithmsInFamily(family)).qwhere(a -> a.getName().equals(split[1])).first();
    }
}
