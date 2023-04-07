package com.java.concurrency.synchronizedkeyword.instance.block;

// this code may create an issue of race condition.
/*class Message
{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(String message) {
        this.message = message;

    }
}*/
/*class ThreadImpl1 implements  Runnable
{
    private String name="adil";
    private Message message;

    public ThreadImpl1(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        synchronized (name)
        {
            name="adil wadhwania";
            message.setMessage("ThreadImpl1");
        }
    }
}

class ThreadImpl2 implements  Runnable
{
    private String name="adil";
    private Message message;

    public ThreadImpl2(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        synchronized (name)
        {
            name="Elon musk";
            message.setMessage("ThreadImpl2");
        }
    }
}*/
public class SyncInstanceBlock
{
    public static void main(String[] args) throws InterruptedException
    {
        Message message=new Message("Ramesh");
        ThreadImpl t1=new ThreadImpl(message);
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("All threads had completed the execution");
    }
}


