package com.ggf.designPattern.Factory;

public class ShapeFactory{
    public Shape getShape(String type) {
        switch (type) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
        }
        return null;
    }
}