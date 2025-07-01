package org.DRTCT.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TravelClass {
    SL("Sleeper"),
    A3("AC 3-Tier"),
    A2("AC 2-Tier"),
    A1("AC First Class");
    private final String label;
}
