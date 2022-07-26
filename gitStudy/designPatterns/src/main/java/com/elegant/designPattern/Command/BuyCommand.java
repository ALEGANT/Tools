package com.elegant.designPattern.Command;

public class BuyCommand implements Command {

    private Stock pstock;

    public BuyCommand(Stock pstock) {
        this.pstock = pstock;
    }

    @Override
    public void execute() {
        pstock.buy();
    }
}
