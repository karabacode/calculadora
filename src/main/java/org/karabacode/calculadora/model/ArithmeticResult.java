package org.karabacode.calculadora.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ArithmeticResult {

    private BigDecimal result;

    public ArithmeticResult(BigDecimal result){
        this.result = result;
    }

    public ArithmeticResult(){}

}
