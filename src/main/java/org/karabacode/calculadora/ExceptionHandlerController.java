package org.karabacode.calculadora;


import org.karabacode.calculadora.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<GenericResponse<Object>> handleIllegalArgument(MethodArgumentTypeMismatchException mat){
        GenericResponse<Object> response = new GenericResponse<>("Arguments invalid",
                "arguments should be passed in this way localhost:8080/arithmetics/SUM/2.89,5.90, operations allowed: SUM. ERROR:" + mat.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
