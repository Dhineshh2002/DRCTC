package org.DRTCT.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaveTrainRequest(
        @NotNull Integer number,
        @NotBlank String name,
        @NotNull Long startStationId,
        @NotNull Long destinationStationId,
        @NotNull Integer totalSeats,
        @NotNull Integer totalWLSeats
) {
}
