package com.java.concurrency.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ReadWriteLockImpl
{
    private int readers=0;
    private int writers=0;
    private int writeRequests=0;

    public synchronized void readLock() throws InterruptedException {
        if(writers>0 || writeRequests>0)
        {
            wait();
        }
        readers++;

    }
    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        writeRequests++;
        while (writers>0 || writeRequests>0)
        {
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite()
    {
        writers--;
        notifyAll();
    }
}
