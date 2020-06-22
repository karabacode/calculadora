package org.karabacode.calculadora.test;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;
import org.karabacode.calculadora.model.ArithmeticResult;
import org.karabacode.calculadora.response.GenericResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

public class SubsTest extends AbstractTest {

    /**
     * test two integers
     */
    @Test
    public void testSubs() throws Exception {
        String ints = "2,8";
        StringBuilder uri =  new StringBuilder("/arithmetics");
        uri.append("/SUBS/");
        uri.append(ints);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri.toString())).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        TypeReference ref = new TypeReference<GenericResponse<ArithmeticResult>>() { };
        GenericResponse<ArithmeticResult> arithmeticResultGenericResponse = (GenericResponse<ArithmeticResult>) this.mapFromJson(content,ref);
        Assert.assertEquals(200, status);
        Assert.assertEquals(new BigDecimal(-6),arithmeticResultGenericResponse.getBody().getResult());


    }
}
