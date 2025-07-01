package org.DRTCT.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "station")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<TrainStationRoute> trainRoutes;

}
