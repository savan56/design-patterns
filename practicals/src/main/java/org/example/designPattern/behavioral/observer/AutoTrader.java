package org.example.designPattern.behavioral.observer;

public class AutoTrader implements StockObserver{
    @Override
    public void onPriceChange(String stock, double oldPrice, double newPrice) {
        if (newPrice < (oldPrice*0.95)){
            System.out.println("AUTO-SELL "+stock+"!");
        }
    }
}
