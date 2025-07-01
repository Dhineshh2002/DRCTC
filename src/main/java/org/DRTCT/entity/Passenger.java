package org.DRTCT.entity;

import jakarta.persistence.*;
import lombok.*;
import org.DRTCT.entity.enums.Gender;

import java.sql.Date;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(nullable = false)
    private Nationality nationality;

    public enum Nationality {
        INDIAN,
        AUSTRALIAN,
        AMERICAN,
        JAPANESE,
        CHINESE,
        KOREAN,
    }
}
