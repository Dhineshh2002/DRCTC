package org.DRTCT.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.DRTCT.entity.Ticket;
import org.DRTCT.entity.Train;
import org.DRTCT.entity.TrainStationRoute;

import java.util.List;

@Builder
@Getter
public class TrainResponse {
    private Long id;
    private String name;
    private Integer number;
    private StationResponse startStation;
    private StationResponse destinationStation;
    private Integer totalSeats;
    private Integer totalWLSeats;
    private List<Ticket> tickets;
    private List<TrainStationRoute> route;

    public static TrainResponse fromEntity(Train train) {
        return TrainResponse.builder()
                .id(train.getId())
                .name(train.getName())
                .number(train.getNumber())
                .startStation(StationResponse.fromEntity(train.getStart()))
                .destinationStation(StationResponse.fromEntity(train.getDestination()))
                .totalSeats(train.getTotalSeats())
                .totalWLSeats(train.getTotalWLSeats())
                .tickets(train.getTickets())
                .route(train.getRoute())
                .build();
    }
}
