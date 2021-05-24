package com.ecc.javalanguage.aboutThread;

import org.jetbrains.annotations.NotNull;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/24-8:50
 */
public class CreateByThread extends Thread{
    public CreateByThread(@NotNull String name) {
        super(name);
    }

    public CreateByThread() {
    }

    @Override
    public void run() {
        System.out.println("HelloThread!");
    }

    public static void main(String[] args) {
        CreateByThread thread = new CreateByThread();
        System.out.println(thread.getName());
        thread.start();
//        new CreateByThread().start();

        CreateByThread thread1 = new CreateByThread("myThread");
        System.out.println(thread1.getName());
        thread1.start();

    }
}
