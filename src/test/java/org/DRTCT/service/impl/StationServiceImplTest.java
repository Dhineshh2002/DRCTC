package org.DRTCT.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.DRTCT.common.ValidateObject;
import org.DRTCT.dto.request.SaveStationRequest;
import org.DRTCT.service.StationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StationServiceImplTest extends ValidateObject {
    @Autowired
    StationService stationService;

    @Test
    void saveStation() {
        SaveStationRequest saveStationRequest = new SaveStationRequest(
                "Mambalam",
                "MBM"
        );
        validate(saveStationRequest);
        stationService.saveStation(saveStationRequest);
    }

    @Test
    void getStationById() {
        log.info("{}", stationService.getStationById(1L));
    }
}