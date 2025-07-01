package org.DRTCT.entity;

import jakarta.persistence.*;
import lombok.*;
import org.DRTCT.entity.enums.Berth;
import org.DRTCT.entity.enums.Status;
import org.DRTCT.entity.enums.TravelClass;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String pnr;

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id", nullable = false)
    private Train train;

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "boarding_station_id", referencedColumnName = "id", nullable = false)
    private Station boardingStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id", referencedColumnName = "id", nullable = false)
    private Station destinationStation;

    @Column(name = "travel_date", nullable = false)
    private LocalDate travelDate;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "travel_class")
    private TravelClass travelClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "berth")
    private Berth berth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "booking_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime bookingTime;
}
