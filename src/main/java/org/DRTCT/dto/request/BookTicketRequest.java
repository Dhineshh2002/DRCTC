package org.DRTCT.dto.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public record BookTicketRequest (
        @NotNull Long trainId,
        @NotNull Long sourceStationId,
        @NotNull Long destinationStationId,
        @NotNull @Size(min = 1) List<Long> passengerIds,
        @NotNull LocalDate journeyDate
) {
}
