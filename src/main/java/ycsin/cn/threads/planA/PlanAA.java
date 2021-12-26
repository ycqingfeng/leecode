package ycsin.cn.threads.planA;

import java.util.concurrent.atomic.AtomicInteger;

public class PlanAA extends Thread {
    static final int TOTAL = 10;
    AtomicInteger center ;

    public PlanAA(AtomicInteger aInt) {
        super("A");
        this.center = aInt;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (center) {
                    center.notifyAll();
                    center.wait();
                    if (center.intValue() % 3 == 0) {
                        System.out.println("A");
                        center.incrementAndGet();
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
