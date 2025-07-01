package org.DRTCT.service.impl;

import org.DRTCT.common.ValidateObject;
import org.DRTCT.dto.request.SavePassengerRequest;
import org.DRTCT.entity.Passenger;
import org.DRTCT.entity.enums.Gender;
import org.DRTCT.service.PassengerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassengerServiceImplTest extends ValidateObject {

    @Autowired
    PassengerService passengerService;

    @Test
    void savePassenger() {
        SavePassengerRequest savePassengerRequest = new SavePassengerRequest(
                "DHINESH",
                22,
                Gender.MALE,
                Passenger.Nationality.INDIAN,
                Date.valueOf("2002-07-01")
        );
        validate(savePassengerRequest);
        passengerService.savePassenger(savePassengerRequest);
    }
}