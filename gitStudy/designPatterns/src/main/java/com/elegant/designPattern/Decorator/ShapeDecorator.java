package com.elegant.designPattern.Decorator;

abstract public class ShapeDecorator implements Shape{
    Shape shape;

    public ShapeDecorator(Shape decoratedShape){
        shape = decoratedShape;
    }

    @Override
    public void draw() {
        System.out.println("Common someThing before");
        shape.draw();
        System.out.println("Common someThing after");
    }
}
