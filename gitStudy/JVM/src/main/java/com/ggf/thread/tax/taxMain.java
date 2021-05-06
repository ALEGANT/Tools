package com.ggf.thread.tax;

import java.util.concurrent.*;

public class taxMain {
    public static void main(String[] args){
        Executor executor = Executors.newFixedThreadPool(2);
        TaxCalaculator calaculator = new TaxCalaculator(10000d,2000d);
        calaculator.setStrategy(new SimpleCalculatorStrategy());
        System.out.println(calaculator.calcTax());
    }
}
