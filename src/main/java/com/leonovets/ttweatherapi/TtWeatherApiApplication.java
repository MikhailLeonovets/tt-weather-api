package com.leonovets.ttweatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application start point.
 */
@SpringBootApplication
public class TtWeatherApiApplication {

    /**
     * Application main method.
     *
     * @param args The command line arguments.
     **/
    public static void main(final String[] args) {
        SpringApplication.run(TtWeatherApiApplication.class, args);
    }

}
