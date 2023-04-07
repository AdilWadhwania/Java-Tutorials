package com.java.concurrency.volatilekeyword;

public class VolatileWrite implements Runnable
{
    private Employee employee;

    public VolatileWrite(Employee employee)
    {
        this.employee = employee;
    }

    @Override
    public void run()
    {

        employee.setEmp_name("Adil");
        try
        {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        employee.setEmp_id(5);
    }
}
