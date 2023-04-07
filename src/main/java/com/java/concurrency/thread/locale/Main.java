package com.java.concurrency.thread.locale;

/**
 * This class is created to test the ThreadLocal variable
 */
public class Main
{
    /**
     *  ThreadLocal variable in java
     *   The variable "name" that we have initialized as "Adil" is a
     *   ThreadLocal variable so the name variable will be "Adil" for Main thread
     *   only.
     *
     *   The thread t1 and t2, when access the "name" threadlocal variable
     *   it will be null because each new thread will create a new instance of threadlocal
     *   variable when first time accessed and value of that variable will be null
     *   if it has not set the value. The main thread's threadlocal variable will be "Adil"
     *    because we have set the value
     * @param args command line arguments
     * @throws InterruptedException join method can throw error
     */
    public static void main(String[] args) throws InterruptedException
    {
        ThreadLocale targetObj=new ThreadLocale("Adil");
        Thread t1=new Thread(targetObj,"A");
        Thread t2=new Thread(targetObj,"B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //Printing the value of ThreadLocal variable at the end after all
        // the threads are executed
        System.out.println(targetObj.getName());
    }
}
