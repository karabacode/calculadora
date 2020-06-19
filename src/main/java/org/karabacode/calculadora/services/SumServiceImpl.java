package org.karabacode.calculadora.services;

import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.corp.calculator.TracerAPI;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component("sum")
public class SumServiceImpl implements ArithmeticsService {

    @Autowired
    private TracerAPI tracerApi;

    @Override
    public ArithmeticResult arithmeticOp(List<BigDecimal> args) {
        tracerApi.trace("Comienzo Suma");
        BigDecimal result = args.stream().reduce(BigDecimal.ZERO, (b1, b2) ->{
            tracerApi.trace(b1.toString() + " + " + b2.toString());
            return b1.add(b2);
        });
        tracerApi.trace(result);
        tracerApi.trace("Fin Suma");
        return new ArithmeticResult(result);
    }
}
