package org.karabacode.calculadora.services;

import org.karabacode.calculadora.model.Operation;
import org.karabacode.calculadora.services.ArithmeticsService;

public interface OperatorFactory {

    public ArithmeticsService getOpService(String operator);

}
