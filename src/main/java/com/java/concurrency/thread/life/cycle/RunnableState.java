package com.java.concurrency.thread.life.cycle;

/*
* In this program we will see the runnable state of thread
* */
public class RunnableState
{
    public static void main(String[] args) throws InterruptedException {
        BlockedStateTest blockedStateTest=new BlockedStateTest();
        Thread t1=new Thread(blockedStateTest);// when we just create the thread it is in the new state

        // If the thread has called start method but the execution is not yet started then it is in runnable state
        t1.start();
        System.out.println(t1.getState());
    }
}
