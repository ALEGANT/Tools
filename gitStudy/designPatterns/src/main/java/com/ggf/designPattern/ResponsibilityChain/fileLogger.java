package com.ggf.designPattern.ResponsibilityChain;

public class fileLogger extends AbstractLogger{

    public fileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void wirte(String message) {
        System.out.println("File::Logger" + message);
    }
}
