package org.DRTCT.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.DRTCT.common.ValidateObject;
import org.DRTCT.dto.request.SaveTrainRouteRequest;
import org.DRTCT.repository.TrainStationRouteRepository;
import org.DRTCT.service.TrainStationRouteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TrainStationRouteImplTest extends ValidateObject {

    @Autowired
    TrainStationRouteService trainStationRouteService;
    @Autowired
    TrainStationRouteRepository trainStationRouteRepository;

    @Test
    void saveTrainRoute() {
        log.info("Count = {} ", trainStationRouteRepository.count());
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 1L, 1, LocalTime.of(22, 15), LocalTime.of(22, 25))); // Chennai Egmore
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 2L, 2, LocalTime.of(22, 36), LocalTime.of(22, 37))); // Mambalam
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 3L, 3, LocalTime.of(22, 55), LocalTime.of(22, 57))); // Tambaram
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 4L, 4, LocalTime.of(23, 28), LocalTime.of(23, 30))); // Chengalpattu
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 5L, 5, LocalTime.of(0, 50), LocalTime.of(0, 55)));   // Villupuram Jn
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 6L, 6, LocalTime.of(1, 54), LocalTime.of(1, 55)));   // Cuddalore Port
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 7L, 7, LocalTime.of(2, 48), LocalTime.of(2, 50)));   // Chidambaram
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 8L, 8, LocalTime.of(3, 6), LocalTime.of(3, 7)));     // Sirkazhi
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 9L, 9, LocalTime.of(3, 50), LocalTime.of(3, 52)));   // Mayiladuturai Jn
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 10L, 10, LocalTime.of(4, 5), LocalTime.of(4, 6)));   // Kuttalam
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 11L, 11, LocalTime.of(4, 17), LocalTime.of(4, 18))); // Aduturai
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 12L, 12, LocalTime.of(4, 28), LocalTime.of(4, 30))); // Kumbakonam
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 13L, 13, LocalTime.of(4, 39), LocalTime.of(4, 40))); // Papanasam
        trainStationRouteService.saveTrainRoute(new SaveTrainRouteRequest(1L, 14L, 14, LocalTime.of(5, 10), LocalTime.of(5, 20)));               // Thanjavur Junction
        log.info("Count = {} ", trainStationRouteRepository.count());
    }

    @Test
    void updateTrainRoute() {
    }

    @Test
    void deleteTrainRoute() {
    }

    @Test
    void getTrainRoute() {
    }
}