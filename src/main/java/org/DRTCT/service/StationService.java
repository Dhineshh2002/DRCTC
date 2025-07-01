package org.DRTCT.service;

import jakarta.validation.constraints.NotNull;
import org.DRTCT.dto.request.SaveStationRequest;
import org.DRTCT.dto.response.StationResponse;
import org.DRTCT.entity.Station;

public interface StationService {

    StationResponse saveStation(SaveStationRequest saveStationRequest);

    void deleteStation(Long id);

    Station getStationById(Long id);
}
