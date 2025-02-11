package org.DRTCT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trainstation", schema = "drtct")
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JoinColumn(name = "train_id", referencedColumnName = "id", nullable = false)
    int trainId;

    @Column(name = "station_name", nullable = false)
    String stationName;

    @Column(name = "arrival_time", nullable = false)
    String arrivalTime;

    @Column(name = "station_order", nullable = false)
    int stationOrder;

    public TrainStation(int trainId, String stationName, String arrivalTime, int stationOrder) {
        this.trainId = trainId;
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.stationOrder = stationOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(int stationOrder) {
        this.stationOrder = stationOrder;
    }
}
