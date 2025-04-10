package com.weatherDashboard.demo.Model;

import java.util.List;
import lombok.Data;

@Data
public class WeatherResponse {
    private double currentTemperature;
    private double currentWindSpeed;

    private List<String> hourlyTimestamps;
    private List<Double> hourlyTemperatures;
    private List<Integer> hourlyHumidity;
    private List<Double> hourlyWindSpeeds;
}
