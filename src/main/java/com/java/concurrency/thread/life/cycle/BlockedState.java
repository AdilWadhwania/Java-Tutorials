package com.java.concurrency.thread.life.cycle;

/*
* Blocked state of thread from thread lifecycle
* In this program we will see how the thread can go into blocked state
* */
public class BlockedState
{
    public static void main(String[] args) throws InterruptedException
    {
        BlockedStateTest block=new BlockedStateTest();

        Thread t1=new Thread(block,"Thread1");
        Thread t2=new Thread(block,"Thread2");

        t1.start();
        t2.start();


        Thread.sleep(1000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.exit(0);
    }
}

/*
* Implementing Runnable means whenever the object of this class is passed in the thread's constructor
* and the start method is called on that thread object, a new thread is created to execute the run method of the
* Runnable object.
* If you simply call the run() method of the Runnable object directly, then it will be executed in the same thread only
* */
class BlockedStateTest implements Runnable
{
    @Override
    public void run()
    {
        forceThreadToBlock();
    }

    /**
     * Thread acquires the lock of the object on which the block or method is synchronized
     * The object through which the method is called, that object is only locked by thread
     * In the case of synchronized method the current object of thread through which this method is called is locked
     * Multiple thread with different object of this class that call this synchronized method can be executed simultaneously
     * Here this method is called by the "block" object declared in the main method so that object is locked
     */
    public  synchronized void forceThreadToBlock()
    {
        System.out.println(Thread.currentThread().getName()+" acquired the lock");

        while (true)
        {
            //The thread that acquire lock on an object first entered will go into infinite loop
            //Due to this the other thread waiting to acquire the lock on the object -
            // -that first thread has acquired will go to blocked state
        }
    }
}