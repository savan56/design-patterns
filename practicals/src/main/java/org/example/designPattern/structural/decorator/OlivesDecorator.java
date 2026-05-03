package org.example.designPattern.structural.decorator;

public class OlivesDecorator implements Pizza{

    private final Pizza wrapper;

    public OlivesDecorator(Pizza pizza){
        this.wrapper = pizza;
    }

    @Override
    public double cost() {
        return wrapper.cost() + 1.0;
    }

    @Override
    public String description() {
        return wrapper.description()+" + "+" Olives";
    }
}
