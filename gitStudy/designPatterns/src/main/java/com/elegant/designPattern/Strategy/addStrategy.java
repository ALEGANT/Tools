package com.elegant.designPattern.Strategy;

public class addStrategy implements Strategy{
    @Override
    public int opertate(int a, int b) {
        return a + b;
    }
}
