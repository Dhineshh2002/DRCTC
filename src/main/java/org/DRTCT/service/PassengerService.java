package org.DRTCT.service;

import org.DRTCT.dto.request.SavePassengerRequest;
import org.DRTCT.dto.response.PassengerResponse;

public interface PassengerService {

    PassengerResponse savePassenger(SavePassengerRequest savePassengerRequest);

}
