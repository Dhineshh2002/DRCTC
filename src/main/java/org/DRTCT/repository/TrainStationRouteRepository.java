package org.DRTCT.repository;

import org.DRTCT.entity.TrainStationRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRouteRepository extends JpaRepository<TrainStationRoute, Long> {

    boolean existsByStationId(Long stationId);
    boolean existsByStopNumber(Integer stopNumber);

}
