package org.DRTCT.dto.request;

import org.DRTCT.entity.Passenger;

public record BookTicketRequest (
        Long trainId,
        Long passengerId


){
}
