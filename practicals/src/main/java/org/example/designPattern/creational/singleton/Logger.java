package org.example.designPattern.creational.singleton;

public class Logger {

    // the one and only instance
    private static volatile Logger instance;

    // private constructor to avoid initialization outside the class
    private Logger(){

    }

    // single entry point
    public static Logger getInstance(){
        if (instance == null){
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message){
        System.out.println("[LOG] " + java.time.LocalDateTime.now() + ": " + message);
    }
}
