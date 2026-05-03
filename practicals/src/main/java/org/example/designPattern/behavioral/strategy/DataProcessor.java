package org.example.designPattern.behavioral.strategy;

public class DataProcessor {
    private SortStrategy strategy;

    public DataProcessor(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void sortData(int[] data, String name){
        System.out.println("applied "+name+" sorting on data");
        strategy.sort(data);
    }
}
