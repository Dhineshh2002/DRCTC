package org.DRTCT.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.SaveTrainRequest;
import org.DRTCT.dto.request.SaveTrainRouteRequest;
import org.DRTCT.entity.Station;
import org.DRTCT.entity.Train;
import org.DRTCT.entity.TrainStationRoute;
import org.DRTCT.repository.StationRepository;
import org.DRTCT.repository.TrainRepository;
import org.DRTCT.repository.TrainStationRouteRepository;
import org.DRTCT.service.StationService;
import org.DRTCT.service.TrainService;
import org.DRTCT.service.TrainStationRouteService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainStationRouteImpl implements TrainStationRouteService {

    private final TrainStationRouteRepository trainStationRouteRepository;
    private final TrainService trainService;
    private final StationService stationService;

    @Override
    public void saveTrainRoute(SaveTrainRouteRequest saveTrainRoute) {
        log.info("saveTrainRoute: method was called for trainId={}", saveTrainRoute.trainId());
        TrainStationRoute trainStationRoute = TrainStationRoute.fromRequest(saveTrainRoute);
        Train train = trainService.getTrainById(saveTrainRoute.trainId());
        Station station = stationService.getStationById(saveTrainRoute.stationId());
        trainStationRoute.setStation(station);
        trainStationRoute.setTrain(train);
        trainStationRouteRepository.save(trainStationRoute);
    }

    @Override
    public void updateTrainRoute(Long Id) {

    }

    @Override
    public void deleteTrainRoute(Long id) {

    }

    @Override
    public void getTrainRoute(Long id) {

    }
}
