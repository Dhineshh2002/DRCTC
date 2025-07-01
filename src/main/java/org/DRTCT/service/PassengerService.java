package org.DRTCT.service;

import org.DRTCT.dto.request.SavePassengerRequest;
import org.DRTCT.dto.response.PassengerResponse;
import org.DRTCT.entity.Passenger;

public interface PassengerService {

    PassengerResponse savePassenger(SavePassengerRequest savePassengerRequest);
    Passenger getPassengerById(Long passengerId);

}
