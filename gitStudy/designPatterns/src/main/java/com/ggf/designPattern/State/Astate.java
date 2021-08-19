package com.ggf.designPattern.State;

class Astate implements State{

    @Override
    public void doSomeThing() {
        System.out.println("Astate.do");
    }
}