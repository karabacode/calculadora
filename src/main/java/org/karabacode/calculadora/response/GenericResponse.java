package org.karabacode.calculadora.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

    private String errorHeader;

    private String errorMessage;

    private T body;

    public GenericResponse(){}

    public GenericResponse(T body) {
        this.body = body;
    }

    public GenericResponse(String errorHeader, String errorMessage) {
        this.errorHeader = errorHeader;
        this.errorMessage = errorMessage;
    }
}
