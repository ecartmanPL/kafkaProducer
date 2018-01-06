package net.siekiera.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Config {
    @Value("${test.value}")
    String test;
    @Bean
    public SimpleProducer createSimpleProducer() {
        SimpleProducer simpleProducer = new SimpleProducer();
        simpleProducer.setTest(test);
        return simpleProducer;
    }
}
