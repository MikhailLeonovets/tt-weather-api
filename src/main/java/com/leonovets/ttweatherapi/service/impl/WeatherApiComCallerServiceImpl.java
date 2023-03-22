package com.leonovets.ttweatherapi.service.impl;

import static com.leonovets.ttweatherapi.model.constant.ConversionFactors.KILOMETERS_TO_METERS_FACTOR;
import static com.leonovets.ttweatherapi.model.constant.ConversionFactors.SECOND_TO_MILLISECONDS_FACTOR;
import com.leonovets.ttweatherapi.config.props.RapidApiProps;
import com.leonovets.ttweatherapi.model.dto.WeatherReportDto;
import com.leonovets.ttweatherapi.repository.entity.WeatherReport;
import com.leonovets.ttweatherapi.service.WeatherStateCallerService;
import com.leonovets.ttweatherapi.service.exception.WeatherApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

/**
 * WeatherApiComCallerServiceImpl implements {@link com.leonovets.ttweatherapi.service.WeatherStateCallerService}.
 * Using Weather Api via Rapid Api.
 *
 * @author Mikhail.Leonovets
 * @since 03/21/2023 - 17:39
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherApiComCallerServiceImpl implements WeatherStateCallerService {
    private final RapidApiProps rapidApiProps;

    @Override
    public WeatherReport getLastWeatherUpdateFromApi(final String location) {
        final String[] cityAndCountry = location.split(" ");
        final String uri = "https://weatherapi-com.p.rapidapi.com/current.json?q=q%3D"
                + cityAndCountry[0] + "%20" + cityAndCountry[1];
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("X-RapidAPI-Host", rapidApiProps.getHost())
                .header("X-RapidAPI-Key", rapidApiProps.getKey())
                .method(String.valueOf(HttpMethod.GET), HttpRequest.BodyPublishers.noBody())
                .build();
        final HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return deserializeWeatherReportFromResponse(response.body()).buildWeatherReportFromDto();
        } catch (IOException | InterruptedException exception) {
            final String message = "Could not retrieve weather state. Exception: ";
            log.warn(message + exception.getMessage());
            throw new WeatherApiException(message + exception.getMessage());
        }
    }

    /**
     * Deserializes WeatherReportDto from incoming json via rapid api.
     *
     * @param json to be deserialized
     * @return deserialized WeatherReportDto
     */
    private WeatherReportDto deserializeWeatherReportFromResponse(final String json) {
        log.warn(json);
        final JSONObject object = new JSONObject(json);
        final JSONObject currentNamedObject = object.getJSONObject("current");
        final JSONObject locationNamedObject = object.getJSONObject("location");
        final WeatherReportDto weatherReportDto = new WeatherReportDto();
        weatherReportDto.setTemperatureCelsius(currentNamedObject.getFloat("temp_c"));
        weatherReportDto.setWindMetersPerHour(currentNamedObject.getFloat("wind_kph") * KILOMETERS_TO_METERS_FACTOR);
        weatherReportDto.setAtmospherePressureHectopascal(currentNamedObject.getFloat("pressure_mb"));
        weatherReportDto.setAirHumidity(currentNamedObject.getInt("humidity"));
        weatherReportDto.setCondition(currentNamedObject.getJSONObject("condition").getString("text"));
        weatherReportDto.setPostDate(new Date(currentNamedObject.getLong("last_updated_epoch") * SECOND_TO_MILLISECONDS_FACTOR));
        weatherReportDto.setLocation(locationNamedObject.getString("name"));
        return weatherReportDto;
    }

}
