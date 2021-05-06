package com.ggf.thread;

public class CreateThread {

    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while(flag){
                System.out.println("working");
                try{
                    Thread.sleep(1_000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("stoped finish");
        });
        thread.start();

        try{
            Thread.sleep(10_000);
        }catch (Exception e){
            e.printStackTrace();
        }
        flag = false;
        System.out.println("stoped");
    }
}


