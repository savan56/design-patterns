package org.example;

import org.example.designPattern.creational.builder.HTTPRequest;
import org.example.designPattern.creational.factory.ShapeFactoryService;
import org.example.designPattern.creational.singleton.Logger;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        for (int i = 1; i <= 5; i++) {
            logger.log("test logging "+ i);
            System.out.println("i = " + i);
        }

        ShapeFactoryService.printAreaOfShape("TRIANGLE");

        HTTPRequest request = new HTTPRequest.Builder("url","POST")
                .setBody("body")
                .setHeaders(new HashMap<>())
                .setTimeout(10)
                .build();
        System.out.println(request.toString());
    }
}