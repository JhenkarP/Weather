package com.weatherDashboard.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenMeteoResponse {
    private Current current;
    private Hourly hourly;

    @Data
    public static class Current {
        @JsonProperty("temperature_2m")
        private double temperature2m;

        @JsonProperty("wind_speed_10m")
        private double windSpeed10m;
    }

    @Data
    public static class Hourly {
        private List<String> time;

        @JsonProperty("temperature_2m")
        private List<Double> temperature2m;

        @JsonProperty("relative_humidity_2m")
        private List<Integer> relativeHumidity2m;

        @JsonProperty("wind_speed_10m")
        private List<Double> windSpeed10m;
    }
}
