package org.karabacode.calculadora.services;

import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.model.Operation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ArithmeticsService {

    ArithmeticResult arithmeticOp(List<BigDecimal> args);
}
