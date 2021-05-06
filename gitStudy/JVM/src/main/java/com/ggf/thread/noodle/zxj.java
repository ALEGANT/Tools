package com.ggf.thread.noodle;

import java.util.concurrent.atomic.AtomicBoolean;

public class zxj extends Thread {

    public static AtomicBoolean[] fork = {new AtomicBoolean(true), new AtomicBoolean(true), new AtomicBoolean(true), new AtomicBoolean(true), new AtomicBoolean(true)};

    private int num;
    private int hungryTimeStart;
    private int hungryTimeEnd;
    private int eatTime;
    private boolean isFull = false;

    public zxj(int num, int hungryTimeStart, int hungryTimeEnd) {
        super();
        this.num = num;
        this.hungryTimeStart = hungryTimeStart;
        this.hungryTimeEnd = hungryTimeEnd;
    }

    @Override
    public void run() {
        while (true) {
            if (!isFull && hungryTimeStart > System.currentTimeMillis() / 1000) {
                if (pickLeftAndRight()) {
                    eatTime = (int) (System.currentTimeMillis() / 1000);
                    hungryTimeEnd = eatTime + (hungryTimeEnd - hungryTimeStart);
                }
            }
            if (!isFull && System.currentTimeMillis() / 1000 > hungryTimeEnd) {
                isFull = true;
                giveLeftAndRight();
            }
        }
    }

    private void giveLeftAndRight() {
        int left = num;
        int right = num == 0 ? 5 : num - 1;
        fork[left].set(true);
        fork[right].set(true);
    }

    private boolean pickLeftAndRight() {
        int left = num;
        int right = num == 0 ? 5 : num - 1;
        if (fork[left].get() && fork[right].get()) {
            fork[left].set(false);
            fork[right].set(false);
            return true;
        }
        return false;
    }

    public static void main(){

    }
}
