package org.karabacode.calculadora;

import org.karabacode.calculadora.services.OperatorFactory;
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
}