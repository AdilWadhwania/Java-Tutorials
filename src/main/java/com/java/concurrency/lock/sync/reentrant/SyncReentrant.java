package com.java.concurrency.lock.sync.reentrant;

/**
 * This class checks the reentrant behavior of
 * the synchronized block.
 *
 * If a thread acquires the lock on an object using synchronized block
 * it can enter any other synchronized blocks that need monitor on same
 * object
 *
 * NOT POSSIBLE CASE :-
 * The reentrance is not possible with the logic written in {@link com.java.concurrency.lock.SimpleLock}
 * class because in that class if a thread tries to acquire the lock it already has will go into the spin
 * lock situation(while loop) due to logic, until the unlock method is not called and release the lock
 * we cannot call the lock method with same thread that already acquires the lock
 */
public class SyncReentrant implements Runnable
{
    @Override
    public void run()
    {
        outerMethod();
    }

    /**
     * This is the outer method where the thread
     * will acquire monitor of "this" current object
     * And then call another synchronized method
     * that acquires same monitor
     */
    private synchronized void outerMethod()
    {
        innerMethod();
    }

    /**
     * THis is the inner synchronized method
     * that acquire the monitor on "this" current object
     *
     * innerMethod is called by the outerMethod, so the
     * thread that acquires monitor in {@link SyncReentrant#outerMethod()} can re-enter
     * this inner method because the thread already has monitor
     * of current "this" object
     */
    private synchronized void innerMethod()
    {
        System.out.println("Inner synchronized method");
    }
}
