package com.ggf.HotSwap;

import java.util.Random;

public class TestClass {
    public static void main(String[] args){
        Random random = new Random();
        while (true) {
            System.out.println(add(random.nextInt(100), random.nextInt(100)));
        }
    }

    public static int add(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}
