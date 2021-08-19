package com.ggf.designPattern.State;

class Context{
    State state = null;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}