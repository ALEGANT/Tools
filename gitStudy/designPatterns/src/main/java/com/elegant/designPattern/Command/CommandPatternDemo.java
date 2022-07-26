package com.elegant.designPattern.Command;

public class CommandPatternDemo {
    public static void main(String[] args){
        Stock abcStock = new Stock();

        BuyCommand buyStockOrder = new BuyCommand(abcStock);
        SellCommand sellStockOrder = new SellCommand(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
