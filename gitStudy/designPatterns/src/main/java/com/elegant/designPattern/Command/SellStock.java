package com.elegant.designPattern.Command;

public class SellStock implements Command {
    private Stock pStock;

    public SellStock(Stock pStock) {
        this.pStock = pStock;
    }

    @Override
    public void execute() {
        pStock.sell();
    }
}
