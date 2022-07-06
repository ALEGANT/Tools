package com.elegant.designPattern.ResponsibilityChain;

public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void wirte(String message) {
        System.out.println("std::Logger" + message);
    }
}
