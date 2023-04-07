package com.java.concurrency.example.odd.even;

public class EvenThread implements Runnable
{
    private final Counter counter;

    public EvenThread(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        /* Synchronized block
          The thread that is executed first will acquire the monitor of
          Counter object because of synchronize block.
         */
        synchronized (counter)
        {
            int counterValue;
            int noOfIteration=counter.getNoOfIteration();
            // it will be executed till the counterValue is equal to noOfIteration
            while((counterValue=counter.getCounter()) <=noOfIteration)
            {
                // Checks the counter value is even or not if not then it will wait
                if (counterValue % 2 != 0)
                {
                    try
                    {
                        /*
                        * Wait method can be called on any of the object by the thread, but the
                        * Thread that is executing should have the monitor of that object in order
                        * to call wait method, if it has in this case yes because of synchronized then
                        * it will release the monitor of that object and wait till notified
                        * */
                        counter.wait();
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    // if it is even then prints the value with the name of thread printing it
                    System.out.println(Thread.currentThread().getName() + " : " + counter.getCounter());
                    counter.incrementCounter();// after printing the value increments the counter
                    /*
                    * notifyAll is similar to wait until the thread does not have the monitor of the
                    * object it is calling notify method on, it will throw an error. In order to call notify
                    * method that thread should have monitor of the object on which it is calling notify.
                    * */
                    counter.notifyAll();
                }
            }
        }
    }
}
