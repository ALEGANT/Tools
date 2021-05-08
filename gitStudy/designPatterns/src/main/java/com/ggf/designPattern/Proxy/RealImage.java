package com.ggf.designPattern.Proxy;

public class RealImage implements Image{
    @Override
    public void display() {
        System.out.println("RealImage::displayer()" + fileName);
    }

    private String fileName = "realImage";

    public void loadFromDisk(String fileName) {
        System.out.println("loadind" + fileName);
    }

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
}
