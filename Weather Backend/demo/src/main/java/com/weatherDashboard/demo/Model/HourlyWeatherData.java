package com.weatherDashboard.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HourlyWeatherData {
    private String timestamp;
    private double temperature;
    private int humidity;
    private double windSpeed;
}
