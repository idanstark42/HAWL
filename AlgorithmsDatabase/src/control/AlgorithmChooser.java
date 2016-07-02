package control;

import model.Algorithm;

/**
 * Created by Idan Stark on 02/07/16.
 */
public interface AlgorithmChooser {

    Algorithm chooseAlgorithm(String description);

}
