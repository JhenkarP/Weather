package com.weatherDashboard.demo.Service;

import com.weatherDashboard.demo.Model.HourlyWeatherData;
import com.weatherDashboard.demo.Model.OpenMeteoResponse;
import com.weatherDashboard.demo.Model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(double latitude, double longitude) {
        String url = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m",
                latitude, longitude);

        OpenMeteoResponse apiResponse = restTemplate.getForObject(url, OpenMeteoResponse.class);
        return mapToWeatherResponse(apiResponse);
    }

    private WeatherResponse mapToWeatherResponse(OpenMeteoResponse apiResponse) {
        WeatherResponse res = new WeatherResponse();

        res.setCurrentTemperature(apiResponse.getCurrent().getTemperature2m());
        res.setCurrentWindSpeed(apiResponse.getCurrent().getWindSpeed10m());

        res.setHourlyTimestamps(apiResponse.getHourly().getTime());
        res.setHourlyTemperatures(apiResponse.getHourly().getTemperature2m());
        res.setHourlyHumidity(apiResponse.getHourly().getRelativeHumidity2m());
        res.setHourlyWindSpeeds(apiResponse.getHourly().getWindSpeed10m());

        return res;
    }

    public HourlyWeatherData getHourlyWeatherByTime(WeatherResponse weatherResponse, String targetTime) {
        var times = weatherResponse.getHourlyTimestamps();
        var temps = weatherResponse.getHourlyTemperatures();
        var humidity = weatherResponse.getHourlyHumidity();
        var wind = weatherResponse.getHourlyWindSpeeds();

        int index = times.indexOf(targetTime);
        if (index == -1)
            return null;

        return new HourlyWeatherData(
                times.get(index),
                temps.get(index),
                humidity.get(index),
                wind.get(index));
    }
}
