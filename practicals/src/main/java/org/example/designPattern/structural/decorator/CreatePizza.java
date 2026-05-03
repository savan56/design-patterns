package org.example.designPattern.structural.decorator;

public class CreatePizza implements Pizza{
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String description() {
        return "Plain Pizza";
    }
}
