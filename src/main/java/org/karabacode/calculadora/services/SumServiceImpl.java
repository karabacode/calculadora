package org.karabacode.calculadora.services;

import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.model.Operation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component("sum")
public class SumServiceImpl implements ArithmeticsService {


    @Override
    public ArithmeticResult arithmeticOp(List<BigDecimal> args) {
    BigDecimal result = args.stream().reduce(BigDecimal.ZERO, (b1, b2) -> b2.add(b1));
    return new ArithmeticResult(result);
    }
}
