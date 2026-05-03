package org.example;

import org.example.designPattern.creational.builder.HTTPRequest;
import org.example.designPattern.creational.factory.ShapeFactoryService;
import org.example.designPattern.creational.singleton.Logger;
import org.example.designPattern.structural.adapter.ExternalWeatherApi;
import org.example.designPattern.structural.adapter.WeatherAdapter;
import org.example.designPattern.structural.adapter.WeatherService;
import org.example.designPattern.structural.decorator.CheezBurstDecorator;
import org.example.designPattern.structural.decorator.CreatePizza;
import org.example.designPattern.structural.decorator.OlivesDecorator;
import org.example.designPattern.structural.decorator.Pizza;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        // singleton design pattern
        Logger logger = Logger.getInstance();

        for (int i = 1; i <= 5; i++) {
            logger.log("test logging "+ i);
            System.out.println("i = " + i);
        }

        // factory design pattern
        ShapeFactoryService.printAreaOfShape("TRIANGLE");

        // builder design pattern
        HTTPRequest request = new HTTPRequest.Builder("url","POST")
                .setBody("body")
                .setHeaders(new HashMap<>())
                .setTimeout(10)
                .build();
        System.out.println(request.toString());

        // adapter design pattern
        WeatherService weather = new WeatherAdapter(new ExternalWeatherApi());
        System.out.println(weather.getTemperatureCelsius("NYC")); // → 25.0

        // decorator design pattern
        Pizza pizza = new CreatePizza();
        System.out.println(pizza.description() +" cost : "+ pizza.cost());

        Pizza cheeseburst = new CheezBurstDecorator(new CreatePizza());
        System.out.println(cheeseburst.description() +" cost : "+ cheeseburst.cost());

        Pizza olivChesezburst = new OlivesDecorator(new CheezBurstDecorator(new CreatePizza()));
        System.out.println(olivChesezburst.description() +" cost : "+ olivChesezburst.cost());
    }

}