package com.weatherDashboard.demo.Controller;

import com.weatherDashboard.demo.Service.WeatherService;
import com.weatherDashboard.demo.Model.WeatherResponse;
import com.weatherDashboard.demo.Model.HourlyWeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public ResponseEntity<WeatherResponse> getCurrentWeather(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return ResponseEntity.ok(weatherService.getWeather(latitude, longitude));
    }

    @GetMapping("/hourly")
    public ResponseEntity<?> getHourlyWeather(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam String time) {

        WeatherResponse weather = weatherService.getWeather(lat, lon);
        HourlyWeatherData data = weatherService.getHourlyWeatherByTime(weather, time);

        if (data == null) {
            return ResponseEntity.status(404)
                    .body("No weather data found for time: " + time);
        }

        return ResponseEntity.ok(data);
    }
}
