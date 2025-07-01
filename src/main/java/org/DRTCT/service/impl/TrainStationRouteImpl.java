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
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

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
        routeExistByStationOrStopNumber(saveTrainRoute);
        TrainStationRoute trainStationRoute = buildTrainStationRoute(saveTrainRoute);
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

    private TrainStationRoute buildTrainStationRoute(SaveTrainRouteRequest saveTrainRoute) {
        TrainStationRoute trainStationRoute = TrainStationRoute.fromRequest(saveTrainRoute);
        Train train = trainService.getTrainById(saveTrainRoute.trainId());
        Station station = stationService.getStationById(saveTrainRoute.stationId());
        trainStationRoute.setStation(station);
        trainStationRoute.setTrain(train);
        return trainStationRoute;
    }

    private void routeExistByStationOrStopNumber(SaveTrainRouteRequest saveTrainRoute) {
        if(trainStationRouteRepository.existsByStationId(saveTrainRoute.stationId())) {
            log.info("Route already exist by this station id={}", saveTrainRoute.stationId());
            throw new DuplicateKeyException("Route already exist by this station id=" + saveTrainRoute.stationId());
        } else if (trainStationRouteRepository.existsByStopNumber(saveTrainRoute.stopNumber())) {
            log.info("Route already exist by this stop number={}", saveTrainRoute.stopNumber());
            throw new DuplicateKeyException("Route already exist by stop number=" + saveTrainRoute.stopNumber());
        }
    }
}
