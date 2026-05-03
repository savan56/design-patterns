package org.example.designPattern.behavioral.strategy;

import java.util.Arrays;

public class QuickSort implements SortStrategy{
    @Override
    public void sort(int[] data) {
//        Quick sort logic
        Arrays.sort(data);
        System.out.println(Arrays.stream(data).boxed().toList());
    }

    @Override
    public String name() {
        return "Quick Sort";
    }
}
