package com.elegant.designPattern.Command;

public class BuyStock implements Command {

    private Stock pstock;

    public BuyStock(Stock pstock) {
        this.pstock = pstock;
    }

    @Override
    public void execute() {
        pstock.buy();
    }
}
