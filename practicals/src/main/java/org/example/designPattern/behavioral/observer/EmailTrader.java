package org.example.designPattern.behavioral.observer;

public class EmailTrader implements StockObserver{
    @Override
    public void onPriceChange(String stock, double oldPrice, double newPrice) {
        System.out.println("Email TRADER: Checking "+stock+" at "+newPrice+"...");
    }
}
