package com.leonovets.ttweatherapi.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:33
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "server.weather.monitoring")
public class WeatherMonitoringProps {
    private String location;

}
