package com.java.concurrency.race.condition;

public class Counter implements Runnable{
    private int count=0;

    /**
     * Increments the count variable.
     */
    public void incrementCount() {
        count++;
    }

    /**
     * <p>This method will increment the count variable by calling
     * {@link #incrementCount()} method in a for loop.
     * </p>
     * <p>
     *     The 450 used in condition may vary, you might face the
     *     issue at 50 or 100 only, so you can gradually increase
     *     the values until you see the race condition
     * </p>
     */
    @Override
    public void run() {
        for (int i = 0; i < 450; i++) {
            incrementCount();
        }
    }

    /**
     * creates two threads t1 and t2 which would increment the
     * count variable.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread t1=new Thread(counter,"t1");
        Thread t2=new Thread(counter,"t2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("After the completion of threads " +
                "value of count : "+counter.count);
    }
}