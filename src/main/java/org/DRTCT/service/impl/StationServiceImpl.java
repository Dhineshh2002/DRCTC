package org.DRTCT.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.SaveStationRequest;
import org.DRTCT.dto.response.StationResponse;
import org.DRTCT.entity.Station;
import org.DRTCT.repository.StationRepository;
import org.DRTCT.service.StationService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    @Override
    public StationResponse saveStation(SaveStationRequest saveStationRequest) {
        log.info("saveStation: method is called");
        if(stationRepository.existsByCode(saveStationRequest.code())) {
            log.error("Station already exist with code={}", saveStationRequest.code());
            throw new DuplicateKeyException("Station already exist with code="+saveStationRequest.code());
        }
        Station station = buildStation(saveStationRequest);
        stationRepository.save(station);
        log.info("A new station saved successfully!");
        return StationResponse.fromEntity(station);
    }

    @Override
    public void deleteStation(Long id) {
        log.info("deleteStation: method called");
        if(!stationRepository.existsById(id)) {
            throw noStationFoundWithId(id);
        }
        stationRepository.deleteById(id);
        log.info("A station deleted successfully!");
    }

    @Override
    public Station getStationById(Long id) {
        return stationRepository.findById(id)
                .orElseThrow(() -> noStationFoundWithId(id));
    }

    private EntityNotFoundException noStationFoundWithId(Long id) {
        log.error("No station has found with id={}", id);
        return new EntityNotFoundException("No station has found with id=" + id);
    }

    private Station buildStation(SaveStationRequest saveStationRequest) {
        return Station.builder()
                .name(saveStationRequest.name())
                .code(saveStationRequest.code())
                .build();
    }
}
