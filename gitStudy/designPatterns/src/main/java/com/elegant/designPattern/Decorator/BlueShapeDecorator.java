package com.elegant.designPattern.Decorator;

public class BlueShapeDecorator extends ShapeDecorator{
    public BlueShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }

    public void draw(){
        System.out.println("Red do someThing before");
        super.draw();
        System.out.println("Red do someThing after");
    }
}
