package com.ggf.designPattern.Strategy;

public class SubtractStrategy implements Strategy{
    @Override
    public int opertate(int a, int b) {
        return a - b;
    }
}
