package org.DRTCT.service;

import org.DRTCT.dto.request.SaveTrainRouteRequest;

public interface TrainStationRouteService {

    void saveTrainRoute(SaveTrainRouteRequest saveTrainRoute);
    void updateTrainRoute(Long Id);
    void deleteTrainRoute(Long id);
    void getTrainRoute(Long id);

}
