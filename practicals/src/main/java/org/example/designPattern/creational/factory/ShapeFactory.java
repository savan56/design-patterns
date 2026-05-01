package org.example.designPattern.creational.factory;

public class ShapeFactory {
    public static Shape calculateArea(String type){
        return switch (type) {
            case "CIRCLE" -> new Circle();
            case "TRIANGLE" -> new Triangle();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
