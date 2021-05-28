package com.ecc.javalanguage.Thread;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/28-15:09
 */
public class Thread2 extends Thread{
    int total;

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 101; i++) {
                total+=i;
            }
            notify();
        }
    }
}
