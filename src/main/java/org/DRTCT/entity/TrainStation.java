package org.DRTCT.entity;

import jakarta.persistence.*;

@Entity
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "train_id", nullable = false)
    int trainId;

    @Column(name = "station_name", nullable = false)
    String stationName;

    @Column(name = "arrival_time", nullable = false)
    String arrivalTime;

    @Column(name = "station_order", nullable = false)
    int stationOrder;

}
