package org.example.designPattern.creational.factory;

public class ShapeFactoryService {
    public static void printAreaOfShape(String type){
        Shape shape = ShapeFactory.calculateArea(type);
        shape.area();
    }
}
