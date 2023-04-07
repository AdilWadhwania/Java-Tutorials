package com.java.concurrency.lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class shows the Simple implementation of lock
 *
 * This implementation does not support the reentrant characteristic
 */
public class SimpleLock
{
    /**
     * This boolean variable is used to keep track of
     * whether the monitor of particular SimpleLock
     * instance is acquired or not
     */
    private boolean isLocked = false;
    private Thread lockedByThread=null;

        /**
         * This method is used to lock
         * So first it checks whether the lock is acquired by another variable
         * or not using the isLocked boolean variable.
         * There are two conditions here
         * ----------------------------------------------------------------------------------------------------
         *
         *      1) If it is true then the current thread will execute the while loop, calls wait method
         *         and releases the monitor on the object instance until the monitor is released and
         *         {@link #isLocked} is encountered as false.
         *
         *      2) And if the {@link #isLocked} variable is false, the thread passes through while loop and
         *         executes the next statement in the method, where it assigns value true to {@link #isLocked}
         *         variable, makes it clear that it has acquired the lock, even if the synchronized
         *         method is completed and the thread releases the monitor acquired while entering the
         *         synchronized method. No other thread can get the monitor until this thread calls
         *         the unlock method and makes the {@link #isLocked} variable false.
         *         One more thing is initialized while first thread calls this method is the Thread object,
         *         and it is initialized with the current calling thread. So when the unlock method is called
         *         it will release the lock, if and only if it is the same thread that has acquired the lock
         * --------------------------------------------------------------------------------------------------
         * @throws InterruptedException wait method can throw this exception
         */
        public synchronized void lock()
                throws InterruptedException{
            while(isLocked){
                wait();
            }
            isLocked = true;
        }

    /**
     * This method is used to make to release the lock
     * There are two scenarios here also
     * ----------------------------------------------------------------------------------------------
     *      1) The thread that calls this method first check whether the thread that
     *         has the right to unlock or not by comparing it with  {@link #lockedByThread}
     *         object to ensure the thread calling unlock method is the one who acquires or has
     *         the lock, if yes then the boolean {@link #isLocked} is assign with false value and
     *         the {@link #lockedByThread} is assigned with null value, to say that no thread is
     *         acquiring the lock of the object instance now.
     *
     *      2) If the thread calling unlock method is different from that of {@link #lockedByThread}
     *         Thread then the if statement will return false and the value of {@link #lockedByThread}
     *         and {@link #isLocked} will remain same
     *----------------------------------------------------------------------------------------------
     */
    public synchronized void unlock(){
        if((Thread.currentThread())==lockedByThread) {
            isLocked = false;
            lockedByThread=null;
            notify();
        }

    }

}
