package com.java.concurrency.synchronizedkeyword.instance.block;

public class ThreadImpl implements Runnable
{
    private Message message;

    public ThreadImpl(Message message)
    {
        this.message = message;
    }

    @Override
    public void run()
    {
        changeMessage();
    }

    /**
     * In this method I have locked the current object(this(ThreadImpl)) using synchronized block
     * and this will behave same as synchronized method, because only one thread can acquire the
     * lock on current ThreadImpl object and all other thread will wait.
     */
    public void changeMessage()
    {
        synchronized (this)
        {
            message.setMessage("Adil");
            System.out.println(message.getMessage());
        }
    }
}
