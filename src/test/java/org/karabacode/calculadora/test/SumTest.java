package org.karabacode.calculadora.test;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;
import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.response.GenericResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;


public class SumTest extends AbstractTest {

    /**
     * test two integers
     */
    @Test
    public void testSum() throws Exception {
        String ints = "2,8";
        StringBuilder uri =  new StringBuilder("/arithmetics");
        uri.append("/SUM/");
        uri.append(ints);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri.toString())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        TypeReference ref = new TypeReference<GenericResponse<ArithmeticResult>>() { };
        GenericResponse<ArithmeticResult> arithmeticResultGenericResponse = (GenericResponse<ArithmeticResult>) this.mapFromJson(content,ref);
        Assert.assertEquals(200, status);
        Assert.assertEquals(new BigDecimal(10),arithmeticResultGenericResponse.getBody().getResult());


    }

    /**
     * test generic error
     */
    @Test
    public void testSumGenericError() throws Exception {
        String ints = "2,fdsa";
        StringBuilder uri =  new StringBuilder("/arithmetics");
        uri.append("/SUM/");
        uri.append(ints);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri.toString())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        TypeReference ref = new TypeReference<GenericResponse<ArithmeticResult>>() { };
        GenericResponse<ArithmeticResult> arithmeticResultGenericResponse = (GenericResponse<ArithmeticResult>) this.mapFromJson(content,ref);
        Assert.assertEquals(500, status);
    }

    /**
     * test no op
     */
    @Test
    public void testSumNoOp() throws Exception {
        String ints = "2,10";
        StringBuilder uri =  new StringBuilder("/arithmetics");
        uri.append("/MUL/");
        uri.append(ints);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri.toString())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        TypeReference ref = new TypeReference<GenericResponse<ArithmeticResult>>() { };
        GenericResponse<ArithmeticResult> arithmeticResultGenericResponse = (GenericResponse<ArithmeticResult>) this.mapFromJson(content,ref);
        Assert.assertEquals(400, status);
    }
}
