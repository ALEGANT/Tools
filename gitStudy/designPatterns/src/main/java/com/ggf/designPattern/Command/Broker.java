package com.ggf.designPattern.Command;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Broker {
    Queue<Command> orderList = new LinkedBlockingQueue<Command>();

    public void takeOrder(Command order){
        orderList.add(order);
    }

    public void placeOrders(){
        for(Command order: orderList){
            order.execute();
        }
        orderList.clear();
    }
}
