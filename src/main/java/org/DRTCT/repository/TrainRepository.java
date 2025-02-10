package org.DRTCT.repository;

import org.DRTCT.entity.Train;
import org.DRTCT.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<Train, Integer> {
    public Train findByTrainName(String trainName);
}
