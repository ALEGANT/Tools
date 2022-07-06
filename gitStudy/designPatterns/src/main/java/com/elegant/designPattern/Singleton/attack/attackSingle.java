package com.elegant.designPattern.Singleton.attack;

import com.ggf.designPattern.Singleton.Hungry.singleTon;

import java.lang.reflect.Constructor;

public class attackSingle {

    public void attack() throws Exception {
        Class singleClass = singleTon.class;
        Constructor con = singleClass.getDeclaredConstructor();
        con.setAccessible(true);
        singleTon single = singleTon.getInstance();
        singleTon newsingle = (singleTon)con.newInstance();
        System.out.println(single == newsingle); // false
    }

}
