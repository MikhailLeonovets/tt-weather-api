package com.leonovets.ttweatherapi.config;

import com.leonovets.ttweatherapi.config.props.WeatherMonitoringProps;
import com.leonovets.ttweatherapi.service.WeatherMonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 20:32
 */
@EnableScheduling
@RequiredArgsConstructor
@Configuration
public class ScheduleWeatherMonitoringConfig implements SchedulingConfigurer {
    private final WeatherMonitoringProps scheduleWeatherMonitoringProps;
    private final WeatherMonitorService weatherMonitorService;

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                () -> weatherMonitorService.doMonitoringForLocation(scheduleWeatherMonitoringProps.getDefaultLocation()),
                new CronTrigger("0 0 * ? * *")
        );
    }
}
