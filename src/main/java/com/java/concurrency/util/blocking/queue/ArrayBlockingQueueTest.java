package com.java.concurrency.util.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * In this class we will see about the {@link ArrayBlockingQueue} that implements the
 * BlockingQueue interface and understand how the {@link BlockingQueue} works
 *
 * The {@link ArrayBlockingQueue} stores the elements in FIFO order, that means the head of the queue
 * is the element that has been in queue for the longest time and the tail of the queue is the
 * element that has been in queue for the shortest time
 */
public class ArrayBlockingQueueTest
{
    /**
     * {@link ArrayBlockingQueue#ArrayBlockingQueue(int, boolean)} Constructor
     *       1) The constructor that we have used here takes two parameter first is the
     *          initial capacity, this initial capacity is initialised because the {@link ArrayBlockingQueue}
     *          internally uses array to store elements so this queue can not store unlimited elements
     *          there is an upper bound, no of elements that can be stored
     *       2) The second parameter is lock fairness and this we passed because the {@link ArrayBlockingQueue}
     *          internally uses {@link java.util.concurrent.locks.ReentrantLock} lock that provides the lock
     *          fairness functionality, if it is true that means the threads acquires the lock in the order
     *          they requested it FIFO order. It ensures that the thread  gets the access of shared resources
     *          in the order they arrived where a thread is waiting to get access for a long time and not able to get it.
     */
    private BlockingQueue<String> stringBlockingQueue=new ArrayBlockingQueue<>(5,true);


/**
 * ------------------------------- Add elements in Blocking Queue -------------------------------
 */

    /**
     * In this method we call the add method of {@link ArrayBlockingQueue} queue to add elements in the
     * {@link BlockingQueue}, let us understand the behaviour of {@link BlockingQueue#add(Object)} method.
     *   - Returns true if the element is successfully added in the queue or else
     *     @throws IllegalStateException if the queue is full.
     * This shows that add method is non-blocking call type method because it does not
     * block the thread if the queue instead throws an exception
     */
    private void arrayQueueAddMethod()
    {
        stringBlockingQueue.add("Ramesh");
    }

    /**
     * In this method we call the {@link BlockingQueue#put(Object)} method of {@link ArrayBlockingQueue}.
     *  - The {@link BlockingQueue#put(Object)} method is blocking call type method that means, if we add
     *    elements using {@link BlockingQueue#put(Object)} method and if the queue is full it will wait until
     *    space is available in the queue to add element and does not throw exception
     *    if the queue is full.
     *  - The {@link BlockingQueue#put(Object)} method does not throw any exception but as the method is a blocking type
     *    and the thread is blocked, if an interrupt call is made to that thread then this
     *    method can throw {@link java.lang.InterruptedException} exception
     */
    private void arrayQueuePutMethod()
    {
        try {
            stringBlockingQueue.put("suresh");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to call the offer method of ArrayBlocking queue and is
     * mostly same as the add method but in the offer method if the queue is full
     * it does not throw the exception rather it will return false
     *  - if queue has space then the element is added to queue and offer method returns
     *    true, whereas when the queue is full the thread is not blocked or waiting until
     *    to get the space in queue rather it will return with false flag.
     */
    private void arrayQueueOfferMethod()
    {
        stringBlockingQueue.offer("kalpesh");
    }

    /**
     * This method call the overloaded offer method of ArrayBlocking queue, and
     * it takes three parameter, first is the element to add, second one is the time
     * as a "long" value that is used to specify how much time should the thread wait if
     * the queue is full to add the elements with it encounter the space in queue and
     * last parameter is the unit of time to wait like minutes or milliseconds
     */
    private void arrayQueueOfferTimerMethod()
    {
        try {
            stringBlockingQueue.offer("Adil",5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/**
 * ------------------------------- End of Add elements in Blocking Queue -------------------------------
 */

/**
 * ------------------------------- Remove elements from Blocking Queue -------------------------------
 */

    /**
     * This method calls the remove method of ArrayBlocking queue.
     * Remove method is used to remove the elements from the head of the
     * queue.
     * There are two scenarios :-
     *      1) It returns true if the queue is not empty
     *      2) If the queue is empty it will false flag
     */
    private void arrayQueueRemoveMethod()
    {
        stringBlockingQueue.remove("Adil");
    }

    /**
     * This method calls the take method of ArrayBlocking queue.
     * It removes the head of the queue if the queue is not empty and
     * waits for the element to be available if the queue is empty
     * While waiting if the thread gets an interrupt call then take method
     * can throw {@link java.lang.InterruptedException} exception
     */
    private void arrayQueueTakeMethod() throws InterruptedException {
        stringBlockingQueue.take();

    }

    /**
     * This method is used to call the poll method of ArrayBlocking queue.
     * The poll method of queue return null if the queue is empty or returns
     * the head of the queue that is removed
     */
    private void arrayQueuePollMethod()
    {
        stringBlockingQueue.poll();
    }

    /**
     * This calls the overloaded poll method with timer as parameter
     * It is same as the offer timer method but the difference is the poll
     * method removes the elements
     *  - Returns the removed head element of the queue
     *  - Returns null if no element is available in the queue after the
     *    waiting time specified in the parameters.
     * While waiting if the thread gets the interrupt call then poll method
     * can throw {@link java.lang.InterruptedException} exception
     */
    private void arrayQueuePollTimerMethod()
    {
        try {
            stringBlockingQueue.poll(5,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/**
 * ------------------------------- End of Remove elements from Blocking Queue -------------------------------
 */


    /**
     * This method calls the element method of ArrayBlocking queue.
     * Element method just retrieves the head of the queue if the queue is not empty
     * and throws {@link java.util.NoSuchElementException} exception
     */
    private void arrayQueueElementMethod()
    {
        stringBlockingQueue.element();
    }

    /**
     * This method calls the peek method of ArrayBlocking queue
     * It will retrieve the head of the queue, if the queue is empty
     * then it will return null.
     */
    private void arrayQueuePeekMethod()
    {
        stringBlockingQueue.peek();
    }
}
