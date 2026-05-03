package org.example.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange {
    private final Map<String, Double> price = new HashMap<>();
    private final List<StockObserver> observers = new ArrayList<>();

    public void subscribe(StockObserver observer){
        observers.add(observer);
    }

    public void unSubscribe(StockObserver observer){
        observers.remove(observer);
    }

    public void updatePrice(String stock, double newPrice){
        double oldPrice = price.getOrDefault(stock, 0.0);
        price.put(stock, newPrice);
        for (StockObserver o : observers){
            o.onPriceChange(stock, oldPrice, newPrice);
        }
    }
}
