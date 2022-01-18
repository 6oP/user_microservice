package com.cbua;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AddressApplication {

    private static final Logger log = LoggerFactory.getLogger(AddressApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
        log.info("Application started");
    }
}
