package org.DRTCT.dto.response;
import lombok.Builder;
import lombok.Getter;
import org.DRTCT.entity.Passenger;
import org.DRTCT.entity.enums.Gender;

import java.sql.Date;

@Builder
@Getter
public class PassengerResponse {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private Passenger.Nationality nationality;
    private Date dateOfBirth;

    public static PassengerResponse create(Passenger passenger) {
        return PassengerResponse.builder()
                .name(passenger.getName())
                .age(passenger.getAge())
                .gender(passenger.getGender())
                .nationality(passenger.getNationality())
                .dateOfBirth(passenger.getDateOfBirth())
                .build();
    }
}
