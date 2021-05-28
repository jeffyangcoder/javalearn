package com.ecc.javalanguage.Thread;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/28-15:09
 */
public class Thread1 extends Thread {
    public static void main(String[] args) {
        Thread2 b = new Thread2();
        b.start();

        synchronized (b){
            try {
                System.out.println("等到计算完成。。。。。。");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2对象计算的总和是" + b.total);
        }
    }
}
