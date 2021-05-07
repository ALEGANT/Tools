package com.ggf.designPattern.Singleton.Lazy;

public class singleTon{
    private static singleTon single;

    private static volatile singleTon single2;

    private singleTon(){}

    public static singleTon getInstance(){
        if(single == null){
            single = new singleTon();
        }
        return single;
    }

    public static synchronized singleTon getInstanceSync(){
        if(single == null){
            single = new singleTon();
        }
        return single;
    }

    public static singleTon getInstanceSync2(){
        if(single2 == null){
            synchronized(singleTon.class){
                if(single2 == null){
                    single2 = new singleTon();
                }
            }
        }
        return single2;
    }
}
