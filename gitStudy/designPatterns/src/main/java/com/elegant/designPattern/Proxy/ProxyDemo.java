package com.elegant.designPattern.Proxy;

public class ProxyDemo {
    public static void main(String[] args){
        Image image = new ProxyImage("image.jpg");
        image.display();
        System.out.println();
        image.display();
    }
}
