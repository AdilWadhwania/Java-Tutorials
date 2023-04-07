package com.java.concurrency.synchronizedkeyword.staticimpl.block;

public class ThreadImpl implements Runnable
{
    private static String name;

    public ThreadImpl(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        synchronized (ThreadImpl.class)
        {
            name="Adil";
        }
    }
}
