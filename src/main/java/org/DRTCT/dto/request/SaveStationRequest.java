package org.DRTCT.dto.request;
import jakarta.validation.constraints.NotBlank;

public record SaveStationRequest (
        @NotBlank String name,
        @NotBlank String code
) {
}
