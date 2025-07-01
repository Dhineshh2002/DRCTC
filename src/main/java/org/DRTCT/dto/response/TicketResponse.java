package org.DRTCT.dto.response;
import lombok.*;
import org.DRTCT.entity.Ticket;
import org.DRTCT.entity.enums.Berth;
import org.DRTCT.entity.enums.Status;
import org.DRTCT.entity.enums.TravelClass;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
public class TicketResponse {

    String pnr;
    LocalDate travelDate;
    TrainResponse train;
    PassengerResponse passenger;
    StationResponse boardingStation;
    StationResponse destinationStation;
    Integer seatNumber;
    BigDecimal price;
    TravelClass travelClass;
    Berth berth;
    Status status;
    LocalDateTime bookingTime;

    public static TicketResponse fromEntity(Ticket ticket) {
        return TicketResponse.builder().build();
    }
}
