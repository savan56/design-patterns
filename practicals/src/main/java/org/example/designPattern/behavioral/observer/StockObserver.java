package org.example.designPattern.behavioral.observer;

public interface StockObserver {
    void onPriceChange(String stock, double oldPrice, double newPrice);
}
