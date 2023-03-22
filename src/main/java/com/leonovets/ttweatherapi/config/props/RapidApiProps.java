package com.leonovets.ttweatherapi.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Properties for Weather API using Rapid Api.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 22:09
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "server.rapid-api")
public class RapidApiProps {
    private String host;
    private String key;
}
