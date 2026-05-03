package org.example.designPattern.structural.adapter;

public class WeatherAdapter implements WeatherService{

    private final ExternalWeatherApi externalWeatherApi;

    public WeatherAdapter(ExternalWeatherApi externalWeatherApi){
        this.externalWeatherApi = externalWeatherApi;
    }


    @Override
    public double getTemperatureCelsius(String city) {

        double temperature = externalWeatherApi.fetchTempFahrenheit(city);

        return (temperature - 32) * ((double) 5 /9);
    }
}
