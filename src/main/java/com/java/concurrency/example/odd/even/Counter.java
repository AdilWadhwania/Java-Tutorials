package com.java.concurrency.exanple.odd.even;

/** Counter class Info
 * In this class we have a counter variable that is accessed by the
 * different thread and incremented according to the logic of the thread.
 * We also have a noOfIteration variable that is the count till we print
 * the numbers
 */
public class Counter
{
    private int counter=0;
    private final int noOfIteration;

    public Counter(int noOfIteration)
    {
        this.noOfIteration = noOfIteration;
    }

    public int getNoOfIteration()
    {
        return noOfIteration;
    }

    public int getCounter()
    {
        return counter;
    }

    public void incrementCounter()
    {
        counter++;
    }

}
