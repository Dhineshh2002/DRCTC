package org.DRTCT.repository;
import org.DRTCT.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    boolean existsByNumber(Integer number);
    boolean existsByNumberAndIdNot(Integer number, Long id);
    Optional<Train> getTrainById(Long trainId);
}
