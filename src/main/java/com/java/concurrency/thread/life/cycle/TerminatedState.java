package com.java.concurrency.thread.life.cycle;

public class TerminatedState
{
    public static void main(String[] args) throws InterruptedException {
        TerminatedThreadTest terminatedState=new TerminatedThreadTest();
        Thread t1=new Thread(terminatedState);
        t1.start();
        Thread.sleep(100);
        System.out.println(t1.getState());
    }
}

class TerminatedThreadTest implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" executed run method");
    }
}