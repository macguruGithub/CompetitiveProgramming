package com.practice.feelofraj.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class test extends Thread {

    int id;

    // 137021; sum=10 // 10101
    // count no of substrings which starts and ends with 1
    // 10111 - 101,1011,10111,11,111,11
    //
    int[] arr = { 1, 3, 7, 0, 2, 1 };
    Thread th2;

    public void run() {
        System.out.println("Implements Runnable " + th2.getName() + "-" + th2.getState());
    }

    public test(Thread th2) {
        this.th2 = th2;
    }

    public test() {
    }

    public test(String string) {
        super(string);
    }

    public String toString() {
        return "" + "-" + this.getState();
    }

    public static void main(String[] args) throws InterruptedException {
        Thrd t = new Thrd();
        Thread th = new Thread(t);
        Thread th1 = new Thread(t);
        th.setName("Naveen");
        th.start();
        th1.setName("Raj");
        th1.start();
    }
}

class Thrd implements Runnable {
    Beans bn = new Beans();
    HashMap<Integer, Integer> now = new HashMap<>();
    HashMap<Integer, Integer> pre = new HashMap<>();

    public Thrd() {
    }

    public void run() {
        pre = display(Thread.currentThread().getName());
        for (Integer k : pre.keySet()) {
            bn.setA(k);
            bn.setB(pre.get(k));
            System.out.println(Thread.currentThread().getName() + ": " + k + "+" + pre.get(k) + "=" + add(bn));
        }

    }

    public HashMap<Integer, Integer> display(String i) {
        System.out.println(Thread.currentThread().getName() + " :) "
                + (Thread.currentThread().getState() == Thread.State.RUNNABLE ? "RUNNING" : ""));
        int c = 1;
        try {
            for (int j = 1; j < 5; j++) {
                now.put(j, c);
                Thread.sleep(1000);
                c++;
            }
            for (Integer l : now.keySet()) {
                System.out.println(now.get(l) + "." + Thread.currentThread().getName());
            }
            ;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return now;
    }

    public int add(Beans bn) {
        return (bn.getA() + bn.getB());
    }

}

class Beans {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
