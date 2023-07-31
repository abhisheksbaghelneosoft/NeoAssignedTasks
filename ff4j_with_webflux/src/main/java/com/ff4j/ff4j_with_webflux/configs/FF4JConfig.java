package com.ff4j.ff4j_with_webflux.configs;

import org.ff4j.FF4j;
import org.ff4j.conf.XmlParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfig {

//    FF4j(XmlParser(), "ff4j-features.xml");

    @Bean
    public FF4j getFF4J()
    {
        return new FF4j(new XmlParser(),"ff4j-features.xml");
    }
}
