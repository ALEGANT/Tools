package main.java.com.ggf.designPattern.State;

public class demo {

    public static void main(String[] args){
        Context context = new Context();
        State aState = new Astate();
        State bState = new Bstate();
        context.setState(aState);
        context.getState().doSomeThing();
        context.setState(bState);
        context.getState().doSomeThing();
    }
}
