package com.artemnizhnyk.somepurejavapractice.one;

import java.util.concurrent.ThreadFactory;

public class VirtualThreads {
    static long counter = 0;
    static void counterIncrement() {
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {




        ThreadFactory threadFactory = Thread.ofVirtual().factory();

        Runnable runnable = () -> {
            for (int i = 0; i < 2500; i++) {
                counterIncrement();
            }
        };
        Thread thread1 = threadFactory.newThread(runnable);
        Thread thread2 = threadFactory.newThread(runnable);
        Thread thread3 = threadFactory.newThread(runnable);
        Thread thread4 = threadFactory.newThread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(counter);
    }
}