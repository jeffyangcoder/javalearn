package com.ecc.javalanguage.aboutThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/24-9:09
 */
public class ByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("By runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ByRunnable());
        thread.start();

//        匿名内部类的写法
        Thread thread1 = new Thread(new ByRunnable() {
            @Override
            public void run() {
                System.out.println("By runnable interface");
            }
        });
        thread1.start();

//        lambda表达式
        Thread thread2 = new Thread(() -> {
            System.out.println("By runnable lambda");
        });
        thread2.start();

        ExecutorService executorService = new ThreadPoolExecutor(1, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executorService.submit(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread pool");
            }
        });
        executorService.shutdown();

    }

}
