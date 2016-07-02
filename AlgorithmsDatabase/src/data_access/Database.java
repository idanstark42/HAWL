package data_access;

import model.Algorithm;
import model.AlgorithmFamily;

/**
 * Created by Idan Stark on 02/07/16.
 */
public interface Database {

    Iterable<AlgorithmFamily> getAllAlgorithemFamilies();

    Iterable<Algorithm> getAlgorithmsInFamily(AlgorithmFamily family);

    void addAlgorithmFamily(AlgorithmFamily family);

    void addAlgorithmToFamily(AlgorithmFamily family, Algorithm algorithm);

    boolean removeAlgorithmFromFamily(AlgorithmFamily family, Algorithm algorithm);

}
