package org.DRTCT.dto.request;

import jakarta.validation.constraints.NotNull;
import org.DRTCT.common.validator.Validatable;

import java.time.LocalTime;

public record SaveTrainRouteRequest(

        @NotNull Long trainId,
        @NotNull Long stationId,
        @NotNull Integer stopNumber,
        @NotNull LocalTime arrivalTime,
        @NotNull LocalTime departureTime

) implements Validatable {
    @Override
    public void validate() {
        if (departureTime.isBefore(arrivalTime)) {
            throw new IllegalArgumentException("Departure cannot be before arrival");
        }
    }
}
