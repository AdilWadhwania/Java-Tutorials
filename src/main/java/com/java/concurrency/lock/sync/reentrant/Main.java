package com.java.concurrency.lock.sync.reentrant;

public class Main
{
    public static void main(String[] args)
    {
        SyncReentrant syncReentrant=new SyncReentrant();
        Thread t1=new Thread(syncReentrant,"A");

        t1.start();

    }
}
