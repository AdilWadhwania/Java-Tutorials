package com.java.concurrency.synchronizedkeyword.instance.method;

public class ThreadImpl implements Runnable
{
    @Override
    public void run()
    {
        printNo();
    }

    /** Synchronized print No method
     * 1) If multiple threads try to access this printNo with same THreadImpl object,
     * then only one thread will be executed at a time, because the first thread that starts
     * executing the printNo method will acquire the lock on the object X, for which other threads will
     * be waiting to release the monitor lock on that object so other thread can execute the method.
     * 2) if multiple threads are executing this method with different objects then the
     * multiple threads can execute this method concurrently because each thread will acquire the
     * object it has call on this method and is not waiting for other thread to release the lock.
     */
    public synchronized void printNo()
    {
        for(int i=0;i<=10;i++)
        {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
