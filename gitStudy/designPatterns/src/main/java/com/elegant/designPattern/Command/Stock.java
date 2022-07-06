package com.elegant.designPattern.Command;

public class Stock {
    private String name = "stock";

    private int quantity = 10;

    public void buy(){
        System.out.println(this.toString() + "buy");
    }

    public void sell(){
        System.out.println(this.toString() + "sell");
    }
}
