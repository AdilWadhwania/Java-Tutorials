package com.java.concurrency.lock.util.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * In this class we have used the reentrant lock
 * provides by the java.util.concurrent.locks package
 *
 * If a thread has monitor of an object, it can
 * again acquire the monitor on same object without
 * blocking that is what reentrant lock means
 *
 * The synchronized block also provides the reentrant
 * feature but the difference is that Reentrant can provide
 * fairness that means it give access of lock to the thread
 * that has wait for the lock for a longer period that
 * synchronized block does not provide
 */
public class ReentrantLockTest
{
    /**
     * The Reentrant lock can be created in this way as
     * well as you pass the boolean value to whether you
     * make the lock fair or not by calling the constructor
     * accordingly
     */
    private ReentrantLock lock=new ReentrantLock();
    private int counter=0;

    /**
     * This outer method increments the counter
     * and whule acquiring the lock it calls the
     * {@link #innerMethod()} that also lock on
     * the same instance that this thread already
     * acquires
     */
    public void outerMethod()
    {
        lock.lock();
        try
        {
            counter++;
            innerMethod();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * The inner method acquires the lock
     * on the {@link #lock} object then
     * increments the counter and unlocks
     */
    private void innerMethod()
    {
        lock.lock();
        try
        {
            counter++;
        }catch (Exception e)
        {
            throw e;
        }finally {
            lock.unlock();
        }
    }
}
