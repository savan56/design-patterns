package org.example;

import org.example.designPattern.creational.singleton.Logger;


public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        for (int i = 1; i <= 5; i++) {
            logger.log("test logging "+ i);
            System.out.println("i = " + i);
        }
    }
}