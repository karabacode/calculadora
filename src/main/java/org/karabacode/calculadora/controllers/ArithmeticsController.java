package org.karabacode.calculadora.controllers;


import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.model.Operation;
import org.karabacode.calculadora.response.GenericResponse;
import org.karabacode.calculadora.services.OperatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArithmeticsController {

    @Autowired
    private OperatorFactory operatorFactory;


    /**
     * receives kind of operation and a list of comma separated numbers
     * @return
     */
    @GetMapping("/arithmetics/{operation}/{args}")
    public ResponseEntity<GenericResponse<ArithmeticResult>> performAirhtmeticOp(@PathVariable Operation operation,
                                                                                 @PathVariable String[] args,
                                                                                 @RequestParam(name = "precision",
                                                                                         required = false,
                                                                                         defaultValue = "4") Integer precision){
        MathContext mathContext = new MathContext(precision, RoundingMode.HALF_UP);
        List<BigDecimal> argsB =  Arrays.stream(args).map(s -> new BigDecimal(s, mathContext)).collect(Collectors.toList());
        ArithmeticResult result =operatorFactory.getOpService(operation.getOpName()).arithmeticOp(argsB);
        return ResponseEntity.ok(new GenericResponse<>(result));
    }


}
