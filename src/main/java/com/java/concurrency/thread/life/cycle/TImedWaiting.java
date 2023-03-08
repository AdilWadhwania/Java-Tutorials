package com.java.concurrency.thread.life.cycle;

public class TImedWaiting
{
    public static void main(String[] args) throws InterruptedException
    {
        TimeWaitThread threadTest=new TimeWaitThread();
        Thread t1=new Thread(threadTest);
        t1.start();
        /*
        * After starting the execution of thread t1 we have tried to
        * call sleep method on current executing thread also here in this
        *  case it is main thread so that the scheduler can pick
        *  thread t1, and we can print the state of thread t1 after it has
        *  started execution
        * */
        Thread.sleep(20);
        System.out.println(t1.getState());
    }
}
class TimeWaitThread implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            // The thread that starts executing run method first
            // will go to sleep for 2 second and that thread will be
            // in timed waiting state for 2 seconds
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
