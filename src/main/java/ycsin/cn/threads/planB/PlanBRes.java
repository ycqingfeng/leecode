package ycsin.cn.threads.planB;

public class PlanBRes {
    private volatile int count;

    public PlanBRes(int count) {
        this.count = count;
    }

    public void printA() {
        synchronized (this) {
            if (count % 3 == 0) {
                System.out.println("A");
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count < 30){
            printA();
        }
    }

    public void printB() {
        synchronized (this) {
            if (count % 3 == 1) {
                System.out.println(" B");
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count < 30){
            printB();
        }
    }

    public void printC() {
        synchronized (this) {
            if (count % 3 == 2) {
                System.out.println("  C");
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count < 30){
            printC();
        }
    }


}
