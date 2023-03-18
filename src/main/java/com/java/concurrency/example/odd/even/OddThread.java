package com.java.concurrency.exanple.odd.even;

public class OddThread implements Runnable
{
    private final Counter counter;

    public OddThread(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        synchronized (counter)
        {
            int counterValue;
            int noOfIteration=counter.getNoOfIteration();
            while((counterValue=counter.getCounter()) <=noOfIteration)
            {
                if (counterValue % 2 == 0)
                {
                    try
                    {
                        counter.wait();
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    System.out.println(Thread.currentThread().getName() + " : " + counter.getCounter());
                    counter.incrementCounter();
                    counter.notifyAll();
                }
            }
        }
    }
}
