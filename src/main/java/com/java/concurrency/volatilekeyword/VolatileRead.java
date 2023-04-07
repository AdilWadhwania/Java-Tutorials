package com.java.concurrency.volatilekeyword;

public class VolatileRead implements Runnable
{
    private Employee employee;

    public VolatileRead(Employee employee)
    {
        this.employee = employee;
    }

    @Override
    public void run()
    {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(employee.getEmp_id());
        System.out.println(employee.getEmp_name());
    }
}
