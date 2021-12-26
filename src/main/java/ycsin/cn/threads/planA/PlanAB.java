package ycsin.cn.threads.planA;

import java.util.concurrent.atomic.AtomicInteger;

public class PlanAB extends Thread {
    private int count = 0;
    AtomicInteger center ;

    public PlanAB(AtomicInteger aInt) {
        super(" B");
        this.center = aInt;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (center) {
                    center.notifyAll();
                    center.wait();
                    if (center.intValue() % 3 == 1) {
                        System.out.println(" B");
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
