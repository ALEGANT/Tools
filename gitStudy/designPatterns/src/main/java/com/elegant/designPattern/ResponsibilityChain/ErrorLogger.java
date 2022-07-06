package com.elegant.designPattern.ResponsibilityChain;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void wirte(String message) {
        System.out.println("ERROR::Logger" + message);
    }
}
