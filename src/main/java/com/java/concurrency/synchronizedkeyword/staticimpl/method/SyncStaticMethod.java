package com.java.concurrency.synchronizedkeyword.staticimpl.method;



public class SyncStaticMethod
{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadImpl thread=new ThreadImpl();
        ThreadImpl thread1=new ThreadImpl();
        Thread t1=new Thread(thread,"A");
        Thread t2=new Thread(thread,"B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("All the threads completed the execution");
    }
}
