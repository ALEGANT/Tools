package com.ggf.thread.ThreadPool;

public class DaemonThread {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Thread innerThread = new Thread(()->{
                    try {
                        for(;;){
                            System.out.println("6666");
                            Thread.sleep(100_000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                innerThread.setDaemon(true);
                innerThread.start();
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
