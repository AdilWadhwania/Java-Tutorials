package com.java.concurrency.thread.life.cycle;

/*
*  In this class we will see the new state of thread from the thread lifecycle
* */
public class NewState
{
    public static void main(String[] args)
    {
        BlockedStateTest blockedStateTest=new BlockedStateTest();
        Thread t1=new Thread(blockedStateTest);// when we just create the thread it is in the new state
        System.out.println(t1.getState());
    }
}
