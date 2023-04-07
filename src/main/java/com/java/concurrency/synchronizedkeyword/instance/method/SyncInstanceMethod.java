package com.java.concurrency.synchronizedkeyword.instance.method;

/*
* if we use same object of ThreadImpl in the thread t1 and t2 then one thread will execute the
* synchronized method written in the ThreadImpl at a time.
* Whereas if we pass different object in the thread t1 and t2 then it will be executed parallely, or
* we can say concurrently that means both thread can execute the synchronized method written in the
* ThreadImpl
* */
public class SyncInstanceMethod
{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadImpl thread=new ThreadImpl();
        ThreadImpl thread1=new ThreadImpl();
        Thread t1=new Thread(thread,"A");
        Thread t2=new Thread(thread1,"B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("All the threads completed the execution");
    }
}
