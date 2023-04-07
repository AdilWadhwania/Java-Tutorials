package com.java.concurrency.create.thread.using.threadclass;

public class Main
{
    public static void main(String[] args)
    {
        UsingThreadClass target=new UsingThreadClass();
        Thread t1=new Thread(target,"Thread A");
        t1.start();// called the start method of the thread
    }
}
