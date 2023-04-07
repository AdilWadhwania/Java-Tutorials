package com.java.concurrency.lock;

public class ReentrantLogic
{
    /**
     * This variable is used to mark that a thread
     * has acquired the lock or not.
     */
    private boolean isLocked=false;
    /**
     * This counter is used to maintain how many
     * times same thread has tried to acquire the
     * lock
     */
    private int reEntrantCount=0;
    /**
     * This thread object keeps track of which thread has acquired
     * this lock
     */
    private Thread lockedByThread;

    /**
     * This method is used to lock, and it is implemented as reentrant lock
     * There are three scenarios
     *------------------------------------------------------------------------------------------------------------------------------
     *      1) When the {@link #isLocked} variable is false and {@link #lockedByThread} variable
     *         is null, at that time the while loop will not be executed the further execution of lock
     *         method continues where the {@link #isLocked} is assigned with true value to ensure
     *         that the current thread has acquired the lock, {@link #reEntrantCount} is incremented, this
     *         variable is used to keep the count how many times the same thread has called the lock method
     *         to acquire the lock, and lastly the {@link #lockedByThread} is assigned with the value of current
     *         Thread to keep track which Thread had acquired the lock
     *
     *      2) When {@link #isLocked} variable is true and the current thread calling the thread is not equal to
     *         the value of {@link #lockedByThread} thread, that means a new Thread had came to acquire the thread,
     *         when both the condition will be true the current thread will be waiting until the lock is released that
     *         it wants to execute.
     *
     *      3) There could be one more case where the {@link #isLocked} variable will be true but the other condition,
     *         this case will occur during reentrant, when a thread that already holds the lock will again want to acquire
     *         the lock, so here the while loop will not be executed and the "if condition" checks that {@link #lockedByThread}
     *         variable is null and isLocked is false then assign the values otherwise we know the value is not going to change
     *         so why to assign every single time of reentrant. The variable that we change is {@link #reEntrantCount}, increment
     *         it, and it is important to keep track how many times the lock method is called by same thread to acquire the lock
     *         it already has.
     *------------------------------------------------------------------------------------------------------------------------------
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException {
        while(isLocked && (Thread.currentThread())!=lockedByThread)
        {
            wait();
        }
        if(lockedByThread==null && !isLocked) {
            isLocked=true;
            lockedByThread = Thread.currentThread();
        }
        reEntrantCount++;
    }

    /**
     * This method is used to release the lock but with reentrant logic implementation
     * There are two scenarios here
     *------------------------------------------------------------------------------------------------------------------------
     *      1) When the "if statement" returns false, the "if statement" returns false when the thread
     *         that has called unlock method is not equal to the thread that has acquired lock and
     *         the information of which thread has acquired the lock is stored in the {@link  #lockedByThread}
     *         variable. In this case they won't be any change, because the thread calling for unlock doesn't
     *         have the lock in first place
     *
     *      2) The second case would be when the ""if statement"" is true that means the thread that has acquired the
     *         lock is calling the unlock method, at that time the code inside "if statement" is executed and first
     *         thing it does it decrement the {@link #reEntrantCount} value, this is done to ensure that the thread
     *         that had acquired the lock on the same instance multiple times have called on the unlock method to
     *         release lock for one of that lock it has acquired for multiple times.
     *
     *         After decrement of {@link #reEntrantCount} variable there would be two cases for next "if statement"
     *          a) The "if statement" returns true that means the {@link #reEntrantCount} variable is equal to zero,
     *             and it indicates that the thread that has acquired the lock on same instances for multiple times had
     *             released all that by calling unlock every single time for the no of time it has acquired the lock
     *          b) The "if statement" returns false and that means the {@link #reEntrantCount} variable is not equal to
     *             zero, and it means that the thread that called this {@link #unlock()} method still has acquired the same
     *             instance multiple times, and it needs to call the unlock method for some more times to get rid of all
     *             locks it has acquired on same instance by calling the {@link #lock()}  method with same thread
     *------------------------------------------------------------------------------------------------------------------------
     */
    public synchronized void unlock()
    {
        if((Thread.currentThread())==lockedByThread)
        {
            reEntrantCount--;
            if(reEntrantCount==0)
            {
                isLocked=false;
                lockedByThread=null;
            }
        }
    }
}
