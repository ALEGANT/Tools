package com.elegant.designPattern.Command;

public class SellCommand implements Command {
    private Stock pStock;

    public SellCommand(Stock pStock) {
        this.pStock = pStock;
    }

    @Override
    public void execute() {
        pStock.sell();
    }
}
