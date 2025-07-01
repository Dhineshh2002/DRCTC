package org.DRTCT.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.SaveTrainRequest;
import org.DRTCT.dto.response.TrainResponse;
import org.DRTCT.entity.Station;
import org.DRTCT.entity.Train;
import org.DRTCT.repository.TrainRepository;
import org.DRTCT.service.StationService;
import org.DRTCT.service.TrainService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {
    private final StationService stationService;
    private final TrainRepository trainRepository;

    @Override
    public TrainResponse saveTrain(SaveTrainRequest saveTrainRequest) {
        log.info("saveTrain: method called");
        if (trainRepository.existsByNumber(saveTrainRequest.number())) {
            trainAlreadyExistByNumber(saveTrainRequest.number());
        }
        Train train = buildTrain(saveTrainRequest);
        trainRepository.save(train);
        log.info("A new train has been created successfully with id={}", train.getId());
        return TrainResponse.fromEntity(train);
    }

    @Override
    public TrainResponse updateTrain(SaveTrainRequest saveTrainRequest, Long id) {
        log.info("updateTrain: method called");
        if (trainRepository.existsByNumberAndIdNot(saveTrainRequest.number(), id)) {
            trainAlreadyExistByNumber(saveTrainRequest.number());
        }
        Train train = findTrainById(id);
        setTrain(train, saveTrainRequest);
        log.info("A train with id={} has been updated successfully!", id);
        return TrainResponse.fromEntity(train);
    }

    @Override
    public Train getTrainById(Long id) {
        return findTrainById(id);
    }

    private void setTrain(Train train, SaveTrainRequest saveTrainRequest) {
        log.info("setTrain: method called");
        Station startStation = stationService.getStationById(saveTrainRequest.startStationId());
        Station destinationStation = stationService.getStationById(saveTrainRequest.destinationStationId());
        train.setStart(startStation);
        train.setDestination(destinationStation);
        train.setName(saveTrainRequest.name());
        train.setNumber(saveTrainRequest.number());
        train.setTotalWLSeats(saveTrainRequest.totalWLSeats());
        train.setTotalSeats(saveTrainRequest.totalSeats());
    }

    private Train buildTrain(SaveTrainRequest saveTrainRequest) {
        log.info("buildTrain: method called");
        Station startStation = stationService.getStationById(saveTrainRequest.startStationId());
        Station destinationStation = stationService.getStationById(saveTrainRequest.destinationStationId());
        Train train = Train.fromRequest(saveTrainRequest);
        train.setDestination(destinationStation);
        train.setStart(startStation);
        return train;
    }

    private void trainAlreadyExistByNumber(Integer number) {
        log.error("Train already exist by this number {}", number);
        throw new DuplicateKeyException("Train already exist by this number " + number);
    }
    private Train findTrainById(Long id) {
        return trainRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Train not found with id={}", id);
                    return new EntityNotFoundException("Train not found with id=" + id);
                });
    }
}
