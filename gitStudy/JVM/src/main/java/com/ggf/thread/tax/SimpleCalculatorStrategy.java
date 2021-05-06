package com.ggf.thread.tax;

public class SimpleCalculatorStrategy implements CalculatorStrategy{

    private final static double TEX_RATE = 0.1 ;
    private final static double BOUNDS_RATE = 0.1 ;
    @Override
    public double calculate(double salary, double bounds) {
        return salary * TEX_RATE + bounds * BOUNDS_RATE;
    }
}
