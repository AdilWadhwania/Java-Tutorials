package com.java.concurrency.synchronizedkeyword.staticimpl.method;

public class ThreadImpl implements Runnable
{
    @Override
    public void run()
    {
        printNo();
    }
    public static synchronized void printNo()
    {
        //System.out.println(Thread.currentThread().getName());
        for(int i=0;i<=10;i++)
        {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
