package com.ff4j.loggertoggle.configs;


import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Ff4jConfig {

    public static final String FRENCH_LANG = "frenchLang";
    public static final String REST_CALL= "restCall";
    public static final String FILE_LOGGER="FILE";
    public static final String CONSOLE_LOGGER="STDOUT";

    @Bean
    public FF4j FF4j(){
        FF4j ff4j = new FF4j();

        Feature frenchLang = new Feature(FRENCH_LANG);
        Feature restCall= new Feature(REST_CALL);
        Feature FILE = new Feature(FILE_LOGGER);
        Feature STDOUT= new Feature(CONSOLE_LOGGER);
        frenchLang.setEnable(true);
        FILE.setEnable(true);
        STDOUT.setEnable(true);

        ff4j.createFeature(frenchLang);
        ff4j.createFeature(restCall);
        ff4j.createFeature(FILE);
        ff4j.createFeature(STDOUT);
        return ff4j;
    }


}

