package com.java.concurrency.volatilekeyword;

public class VolatileTest
{
    public static void main(String[] args) throws InterruptedException {
        Employee employee=new Employee(1,"Ramesh");
        VolatileWrite volatileWrite=new VolatileWrite(employee);
        Thread t1=new Thread(volatileWrite,"W");
        VolatileRead volatileRead=new VolatileRead(employee);
        Thread t2=new Thread(volatileRead);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("All threads had completed execution");
    }
}
