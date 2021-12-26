package ycsin.cn.threads.planA;

import java.util.concurrent.atomic.AtomicInteger;

public class PlanAC extends Thread {
    private int count = 0;
    AtomicInteger center ;

    public PlanAC(AtomicInteger aInt) {
        super("  C");
        this.center = aInt;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (center) {
                    center.notifyAll();
                    center.wait();
                    if (center.intValue() % 3 == 2) {
                        System.out.println("  C");
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
