package com.java.concurrency.create.thread.using.runnableinterface;

import com.java.concurrency.synchronizedkeyword.instance.block.ThreadImpl;

public class Main
{
    public static void main(String[] args)
    {
        UsingRunnable targetObj=new UsingRunnable();
        Thread t1=new Thread(targetObj,"Thread B");
        t1.start();// will internally call run method of UsingRunnable class
    }
}
