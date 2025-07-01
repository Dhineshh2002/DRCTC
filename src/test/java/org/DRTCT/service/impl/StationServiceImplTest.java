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
        SaveStationRequest chennaiEgmore = new SaveStationRequest("Chennai Egmore", "MS ");
        SaveStationRequest mambalam = new SaveStationRequest("Mambalam", "MBM ");
        SaveStationRequest tambaram = new SaveStationRequest("Tambaram", "TBM ");
        SaveStationRequest chengalpattu = new SaveStationRequest("Chengalpattu", "CGL ");
        SaveStationRequest villupuramJn = new SaveStationRequest("Villupuram Jn", "VM ");
        SaveStationRequest cuddalorePort = new SaveStationRequest("Cuddalore Port", "CUPJ ");
        SaveStationRequest chidambaram = new SaveStationRequest("Chidambaram", "CDM ");
        SaveStationRequest sirkazhi = new SaveStationRequest("Sirkazhi", "SY ");
        SaveStationRequest mayiladuturaiJn = new SaveStationRequest("Mayiladuturai Jn", "MV ");
        SaveStationRequest kuttalam = new SaveStationRequest("Kuttalam", "KTM ");
        SaveStationRequest aduturai = new SaveStationRequest("Aduturai", "ADT ");
        SaveStationRequest kumbakonam = new SaveStationRequest("Kumbakonam", "KMU ");
        SaveStationRequest papanasam = new SaveStationRequest("Papanasam", "PML ");
        SaveStationRequest thanjavurJn = new SaveStationRequest("Thanjavur Junction", "TJ ");

        stationService.saveStation(chennaiEgmore);
        stationService.saveStation(mambalam);
        stationService.saveStation(tambaram);
        stationService.saveStation(chengalpattu);
        stationService.saveStation(villupuramJn);
        stationService.saveStation(cuddalorePort);
        stationService.saveStation(chidambaram);
        stationService.saveStation(sirkazhi);
        stationService.saveStation(mayiladuturaiJn);
        stationService.saveStation(kuttalam);
        stationService.saveStation(aduturai);
        stationService.saveStation(kumbakonam);
        stationService.saveStation(papanasam);
        stationService.saveStation(thanjavurJn);

    }

    @Test
    void getStationById() {
        log.info("{}", stationService.getStationById(1L));
    }
}