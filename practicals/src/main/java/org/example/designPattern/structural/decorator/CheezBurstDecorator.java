package org.example.designPattern.structural.decorator;

public class CheezBurstDecorator implements Pizza{

    private final Pizza wrapper;

    public CheezBurstDecorator(Pizza wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public double cost() {
        return wrapper.cost() + 2.0;
    }

    @Override
    public String description() {
        return wrapper.description() + " + " + "Cheese burst";
    }
}
