package com.ggf.thread;

public class TicketWindowRunable implements Runnable{
    public final static int MAX = 10000;
    public static int now = 0;
    @Override
    public void run() {
        for (; ; ){
            if (now <= MAX) {
                System.out.println(this.getClass().getName() + ":" + now);
                now++;
            }
        }
    }
}
