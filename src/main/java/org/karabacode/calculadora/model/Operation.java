package org.karabacode.calculadora.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Operation {
    SUM("sum"),
    SUBS("subs");

    private final String opName;


    Operation(String opName) {
        this.opName = opName;
    }
}
