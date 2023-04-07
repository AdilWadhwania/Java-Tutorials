package com.java.concurrency.create.thread.using.threadclass;

/**
 * Creating a thread by extending the Thread class in java
 */
public class UsingThreadClass extends Thread
{
    /**
     * We need to implement the run method because whenever you call
     * start method on the Thread object it internally calls the thread's(ThreadImpl) run method
     * that is implemented here
     */
    @Override
    public void run()
    {
        System.out.println("Creating a thread by extending the Thread class");
    }
}
