package org.DRTCT.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Berth {
    LB("Lower Birth"),
    UP("Upper Birth"),
    MB("Middle Birth"),
    SL("Side Lower"),
    SU("Side Upper");
    private final String label;
}
