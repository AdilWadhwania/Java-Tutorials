package com.java.concurrency.synchronizedkeyword.staticimpl.block;

public class SyncStaticBlock
{

    public static void main(String[] args) throws InterruptedException {

        ThreadImpl t1=new ThreadImpl("Ramesh");
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All threads had completed the execution");
    }
}
