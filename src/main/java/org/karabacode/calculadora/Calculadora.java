package org.karabacode.calculadora;


import io.corp.calculator.TracerAPI;
import org.karabacode.calculadora.services.OperatorFactory;
import org.karabacode.calculadora.util.TracerCustom;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Calculadora {

    public static void main(String[] args) {

        SpringApplication.run(Calculadora.class, args);
    }

    @Bean("operatorFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(OperatorFactory.class);
        return factoryBean;

    }

    @Bean("tracerApi")
    public TracerAPI tracerApi(){
        return new TracerCustom();
    }
}