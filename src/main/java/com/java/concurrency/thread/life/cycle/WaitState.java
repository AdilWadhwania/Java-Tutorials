package com.java.concurrency.thread.life.cycle;

/*
* Message object contains a string that holds the message
* We have a constructor and getter & setter method for the private message field
* */
class Message
{
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

public class WaitState
{
    /*
    * Main method contains thread, two waiter thread and 1 notifier thread
    * */
    public static void main(String[] args)
    {
        Message message = new Message("initial message");


        Waiter waiter1 = new Waiter(message);
        Thread thread1 = new Thread(waiter1, "Waiter 1");

        Waiter waiter2 = new Waiter(message);
        Thread thread2 = new Thread(waiter2, "Waiter 2");

        Notifier notifier = new Notifier(message);
        Thread thread3 = new Thread(notifier, "Notifier");

        thread1.start();
        thread2.start();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        thread3.start();
    }
}


/*
* This class will implement the wait method
* we need to initialize the message object while calling this class
* */
class Waiter implements Runnable
{
    private static Message message;
    public Waiter(Message message)
    {
        this.message = message;
    }
    public void run()
    {
        //the thread that first enters into this synchronized block will acquire the lock on the message object
        synchronized (message)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " is waiting for notification.");
                message.wait();// the current thread will wait and releases lock on message object until it is notified
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has received notification: " + message.getMessage());
        }
    }
}

/*
* Same we have a notifier class that notifies once the work is done
* */
class Notifier implements Runnable
{
    private Message message;
    public Notifier(Message message)
    {
        this.message = message;
    }

    public void run()
    {
        // The thread that enters the synchronized block first will acquire lock on message object
        synchronized (message)
        {
            System.out.println(Thread.currentThread().getName() + " is notifying waiting thread.");
            message.setMessage("Hello World!");//modifies the message object
            //Once the modification is done the message.notifyALl method will notify to all the threads that are waiting
            //to acquire monitor lock that now they can continue there process
            message.notifyAll();
        }
    }
}

