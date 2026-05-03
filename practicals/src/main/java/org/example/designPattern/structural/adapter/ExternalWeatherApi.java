package org.example.designPattern.structural.adapter;

public class ExternalWeatherApi {
    public double fetchTempFahrenheit(String cityCode) {
        // Simulates API call — returns Fahrenheit
        // actual code has the city level bifurcation to get the actual data
        return 77.0; // 77°F = 25°C
    }
}
