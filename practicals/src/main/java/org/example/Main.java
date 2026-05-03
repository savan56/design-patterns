package org.example;

import org.example.designPattern.behavioral.observer.AutoTrader;
import org.example.designPattern.behavioral.observer.EmailTrader;
import org.example.designPattern.behavioral.observer.MobileAppAlert;
import org.example.designPattern.behavioral.observer.StockExchange;
import org.example.designPattern.behavioral.strategy.*;
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
import org.example.designPattern.structural.facade.HotelReceptionFacade;
import org.example.designPattern.structural.proxy.UserAccountRepo;
import org.example.designPattern.structural.proxy.UserAuthenticationProxy;
import org.example.designPattern.structural.proxy.UserRepository;

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

        // Facade design pattern
        HotelReceptionFacade receptionFacade = new HotelReceptionFacade();
        receptionFacade.getLaundryDone();
        receptionFacade.planMyEvening();

        //proxy design pattern
        UserRepository repo = new UserAuthenticationProxy(new UserAccountRepo());
        repo.getUserAccountByAccountNumber("123-456-789");

        // Strategy design pattern
        DataProcessor processor = new DataProcessor(new BubbleSort());
        processor.sortData(new int[]{4,3,6,7,1,2,5}, "Bubble Sort");

        processor.changeStrategy(new InsertionSort());
        processor.sortData(new int[]{4,3,6,7,1,2,5}, "Insertion Sort");

        processor.changeStrategy(new QuickSort());
        processor.sortData(new int[]{4,3,6,7,1,2,5}, "Quick Sort");

        // observer design pattern
        StockExchange exchange = new StockExchange();
        exchange.subscribe(new EmailTrader());
        exchange.subscribe(new MobileAppAlert());
        exchange.subscribe(new AutoTrader());

        exchange.updatePrice("APPL",150.0);
        exchange.updatePrice("APPL",140.00);

    }

}