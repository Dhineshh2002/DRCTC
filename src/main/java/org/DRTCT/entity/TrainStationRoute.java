package org.DRTCT.entity;

import jakarta.persistence.*;
import lombok.*;
import org.DRTCT.dto.request.SaveTrainRouteRequest;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "train_station_route")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TrainStationRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id", nullable = false)
    private Train train;

    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id", nullable = false)
    private Station station;

    @Column(name = "stop_number", nullable = false)
    private int stopNumber;

    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

    public static TrainStationRoute fromRequest(SaveTrainRouteRequest saveTrainRoute) {
        return TrainStationRoute.builder()
                .stopNumber(saveTrainRoute.stopNumber())
                .arrivalTime(saveTrainRoute.arrivalTime())
                .departureTime(saveTrainRoute.departureTime())
                .build();
    }
}
