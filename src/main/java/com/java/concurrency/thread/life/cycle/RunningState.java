package com.java.concurrency.thread.life.cycle;

public class RunningState
{
    public static void main(String[] args)
    {
        RunningThreadTest runningThreadTest=new RunningThreadTest();
        // when we just create the thread it is in the new state
        Thread t1=new Thread(runningThreadTest);
        //Internally will call the run method of ThreadTest class
        t1.start();

    }
}
class RunningThreadTest implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
