package org.DRTCT.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.DRTCT.entity.Passenger;
import org.DRTCT.entity.enums.Gender;

import java.sql.Date;


public record SavePassengerRequest(

        @NotBlank String name,
        @NotNull Integer age,
        @NotNull Gender gender,
        @NotNull Passenger.Nationality nationality,
        Date dateOfBirth

) {
}
