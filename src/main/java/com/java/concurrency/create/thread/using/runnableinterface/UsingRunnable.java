package com.java.concurrency.create.thread.using.runnableinterface;

/**
 * Creating a thread by implementing the runnable interface
 */
public class UsingRunnable implements Runnable
{
    /**
     * We need to implement the run method because this class has
     * implemented the Runnable interface and this interface has only
     * one method that is "run" method.
     */
    @Override
    public void run()
    {
        System.out.println("Running the thread by implementing Runnable interface");
    }
}
