package com.java.concurrency;

/*
* In this class we are going to see about join in java
* Whenever a current executing thread encounters join method from an X thread then the current executing thread will wait
* until the X thread's execution is completed.
* */
public class JoinMethod
{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadIterate threadIterate=new ThreadIterate();
        Thread t1=new Thread(threadIterate);
        t1.start();
        t1.join();//here main thread will wait till the main threads execution is completed

        System.out.println("Worker thread execution completed");
    }
}
class ThreadIterate implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(i);
        }
    }
}
