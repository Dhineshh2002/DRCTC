package org.DRTCT.entity;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name="train", schema = "drtct")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "train_number", nullable = false, length = 20)
    private String trainNumber;

    @Column(name = "train_name", nullable = false, length = 100)
    private String trainName;

    @Column(name = "start_place", nullable = false, length = 100)
    private String startPlace;

    @Column(name = "destination_place", nullable = false, length = 100)
    private String destinationPlace;

    @Column(name = "total_hours_of_travel", nullable = false)
    private int totalHoursOfTravel;

    @Column(name = "available_ticket_based_on_class", nullable = false)
    private String availableTicketBasedOnClass;

    @Column(name = "last_modified", nullable = false, length = 100)
    private Timestamp lastModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public int getTotalHoursOfTravel() {
        return totalHoursOfTravel;
    }

    public void setTotalHoursOfTravel(int totalHoursOfTravel) {
        this.totalHoursOfTravel = totalHoursOfTravel;
    }

    public String getAvailableTicketBasedOnClass() {
        return availableTicketBasedOnClass;
    }

    public void setAvailableTicketBasedOnClass(String availableTicketBasedOnClass) {
        this.availableTicketBasedOnClass = availableTicketBasedOnClass;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}
