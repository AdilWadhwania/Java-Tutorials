package com.java.concurrency.lock.util.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This class shows the ReadWriteLock of java.utils.lock package
 * This lock is useful when most of the threads read the shared resource
 * and very few threads are used to write to a shared resource
 *
 * It provides the functionality that multiple threads can read the same
 * shared resource using readlock.lock() method and write to a resource is
 * done by only one thread at a time this is ensured by writelock method of
 * lock instance
 *
 * The ReadWriteLock is an interface, and it is implemented by
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock} class
 * So it has all the features that reentrant lock provides.
 */
public class ReadWriteLockTest
{
    private volatile int count=0;
    private ReadWriteLock lock=new ReentrantReadWriteLock();

    /**
     * While setting the count variable we have used
     * the writeLock to ensure that a thread can update the value
     * of count variable at a time
     * @param newValue the value to be updated
     */
    public void setCount(int newValue)
    {
        lock.writeLock().lock();
        try{
            count=newValue;
        }finally {
            lock.writeLock().unlock();

        }
    }

    /**
     * In this method we have used the ReadLock that means
     * multiple method can read same resources, the count variable
     * is volatile variable that will ensure the latest value and
     * visibility guarantee
     * @return
     */
    public int getCount()
    {
        lock.readLock().lock();
        try{
            return count;
        }finally {
            lock.readLock().unlock();
        }
    }
}
