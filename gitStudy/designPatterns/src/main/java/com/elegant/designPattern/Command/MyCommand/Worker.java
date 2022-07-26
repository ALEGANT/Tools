package com.elegant.designPattern.Command.MyCommand;

import com.elegant.designPattern.Command.Command;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    List<Order> OrderList = new ArrayList<Order>();

    public void addOrder(Order order){
        OrderList.add(order);
    }

    public void run(){
        for(Order order: OrderList){
            order.execute();
        }
        OrderList.clear();
    }
}
