package org.DRTCT.entity;

import jakarta.persistence.*;
import lombok.*;
import org.DRTCT.dto.request.SaveTrainRequest;

import java.util.List;

@Entity
@Table(name = "train")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "train_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "start_station_id", nullable = false)
    private Station start;

    @ManyToOne
    @JoinColumn(name = "destination_station_id", nullable = false)
    private Station destination;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @Column(name = "total_wl_seats", nullable = false)
    private Integer totalWLSeats;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<TrainStationRoute> route;

    public static Train fromRequest(SaveTrainRequest saveTrainRequest) {
        return Train.builder()
                .name(saveTrainRequest.name())
                .number(saveTrainRequest.number())
                .totalSeats(saveTrainRequest.totalSeats())
                .totalWLSeats(saveTrainRequest.totalWLSeats())
                .build();
    }

}
