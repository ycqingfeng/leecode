package ycsin.cn.threads;

import ycsin.cn.threads.planA.PlanAA;
import ycsin.cn.threads.planA.PlanAB;
import ycsin.cn.threads.planA.PlanAC;
import ycsin.cn.threads.planB.PlanBRes;

import java.util.concurrent.atomic.AtomicInteger;

public class Abc {


    public static void main(String[] args) {
        planA();
//        planB();
    }

    private static void planB() {
        final PlanBRes res = new PlanBRes(30);
        new Thread(new Runnable() {

            public void run() {
                res.printA();
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                res.printB();
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                res.printC();
            }
        }).start();
    }

    private static void planA(){
        AtomicInteger aInt = new AtomicInteger(0);

        new PlanAA( aInt).start();
        new PlanAB( aInt).start();
        new PlanAC( aInt).start();
    }

}
