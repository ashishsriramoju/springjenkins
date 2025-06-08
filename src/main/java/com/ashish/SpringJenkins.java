package com.ashish;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJenkins {

    public Logger logger = LoggerFactory.getLogger(SpringJenkins.class);

    @PostConstruct
    public void init(){
        logger.info("Application starter ......");
    }

    public static void main(String args[]){
        SpringApplication.run(SpringJenkins.class, args);
    }

}
