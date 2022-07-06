package com.elegant.designPattern.Singleton.Hungry;

public class singleTon{
    private static singleTon single = new singleTon();
    private singleTon(){}
    public static singleTon getInstance() {
        return single;
    }
}
