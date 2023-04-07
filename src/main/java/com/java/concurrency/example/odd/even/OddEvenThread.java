package com.java.concurrency.example.odd.even;

/*  Example overview
*  In this example we want to print the odd numbers by odd thread
*  and even number by even thread so for that we have used a counter
*  variable to increment and print all the odd and even number using odd
*  and even thread respectively until the mentioned no of iterations
* */
public class OddEvenThread
{
    /** Main method Info
     * we have created a counter object and passed same object to both
     * odd and even thread
     * @param args command line arguments
     * @throws InterruptedException throws by the join method
     */
    public static void main(String[] args) throws InterruptedException
    {
        Counter counter=new Counter(100);
        EvenThread evenThread=new EvenThread(counter);
        Thread t1=new Thread(evenThread,"Even");
        OddThread oddThread=new OddThread(counter);
        Thread t2=new Thread(oddThread,"Odd");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main method completed");
    }
}


