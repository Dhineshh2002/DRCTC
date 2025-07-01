package org.DRTCT.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.DRTCT.dto.request.SavePassengerRequest;
import org.DRTCT.dto.response.PassengerResponse;
import org.DRTCT.entity.Passenger;
import org.DRTCT.repository.PassengerRepository;
import org.DRTCT.service.PassengerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Override
    public PassengerResponse savePassenger(SavePassengerRequest savePassengerRequest) {
        log.info("savePassenger: method called");
        Passenger passenger = buildPassenger(savePassengerRequest);
        passengerRepository.save(passenger);
        return PassengerResponse.create(passenger);
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> {
                    log.error("Passenger is not found with id={}", passengerId);
                    return new EntityNotFoundException("Passenger not found with id=" + passengerId);
                });
    }

    private Passenger buildPassenger(SavePassengerRequest savePassengerRequest) {
        return Passenger.builder()
                .name(savePassengerRequest.name())
                .age(savePassengerRequest.age())
                .gender(savePassengerRequest.gender())
                .nationality(savePassengerRequest.nationality())
                .dateOfBirth(savePassengerRequest.dateOfBirth())
                .build();
    }
}
