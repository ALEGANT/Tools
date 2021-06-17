package com.ggf.designPattern.Command.MyCommand;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    List<Order> OrderList = new ArrayList<Order>();

    public void addOrder(Order order){
        OrderList.add(order);
    }

    public void run(){
        while(!OrderList.isEmpty()){

        }
    }
}
