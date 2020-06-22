package org.karabacode.calculadora.services;

import io.corp.calculator.TracerAPI;
import org.karabacode.calculadora.model.ArithmeticResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("subs")
public class SubsServiceImpl implements ArithmeticsService {

    @Autowired
    private TracerAPI tracerApi;

    @Override
    public ArithmeticResult arithmeticOp(List<BigDecimal> args) {
        tracerApi.trace("Comienzo Resta");
        BigDecimal subtotal = args.get(0);
        BigDecimal result = args.subList(1,args.size()).stream().reduce(subtotal, (b1, b2) ->{
            tracerApi.trace(b1.toString() + " - " + b2.toString());
            return b1.subtract(b2);
        });
        tracerApi.trace(result);
        tracerApi.trace("Fin Resta");
        return new ArithmeticResult(result);
    }
}
