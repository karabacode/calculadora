package org.karabacode.calculadora.controllers;


import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.response.GenericResponse;
import org.karabacode.calculadora.services.OperatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArithmeticsController {


    @Autowired
    private OperatorFactory operatorFactory;

    /**
     * receives kind of operation and a list of numbers separated by character |
     * @return
     */
    @GetMapping("/arithmetics/{operation}/{args})
    public ResponseEntity<GenericResponse<ArithmeticResult>> performAirhtmeticOp(@PathVariable Operation operation,
                                                                                 @PathVariable String[] args,
                                                                                 @RequestParam(name = "precision",
                                                                                         required = false,
                                                                                         defaultValue = "4") Integer precision){

        String[] argsArray = args.split(Constants.ARG_SEPARATOR);
        List<BigDecimal> argsBigDecimal =  Arrays.stream(argsArray).map(s -> new BigDecimal(s, mathContext)).collect(Collectors.toList());
        ArithmeticResult result = operatorFactory.getOpService(operation.getOpName()).arithmeticOp(argsBigDecimal);
        return ResponseEntity.ok(new GenericResponse<>(result));
    }


}
