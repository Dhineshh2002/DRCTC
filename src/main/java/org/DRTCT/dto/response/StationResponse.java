package org.DRTCT.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.DRTCT.entity.Station;

@Builder
@Getter
public class StationResponse {

    private Long id;
    private String name;
    private String code;

    public static StationResponse fromEntity(Station station) {
        return StationResponse.builder()
                .id(station.getId())
                .name(station.getName())
                .code(station.getCode())
                .build();
    }
}
