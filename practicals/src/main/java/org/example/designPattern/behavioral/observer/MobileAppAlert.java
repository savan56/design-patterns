package org.example.designPattern.behavioral.observer;

public class MobileAppAlert implements StockObserver{
    @Override
    public void onPriceChange(String stock, double oldPrice, double newPrice) {
        System.out.println("Mobile APP: "+stock+" changed from "+oldPrice+" to "+newPrice);
    }
}
