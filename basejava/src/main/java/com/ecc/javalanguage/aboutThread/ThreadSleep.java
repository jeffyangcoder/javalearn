package com.ecc.javalanguage.aboutThread;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/28-14:30
 */
public class ThreadSleep {

    public static void main(String[] args) {
        Thread thread1 = new MyThread("thread1");
        Thread thread2 = new MyThread("thread2");
        thread1.start();
        thread2.start();
    }

    static class MyThread extends Thread{
        public MyThread(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            for (int i = 0; i < 150; i++) {
//                try {
//                    Thread.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(this.getName() + ":" + i);
                Thread.yield();
            }
        }
    }
}
