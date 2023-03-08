package com.java.classes.and.object;

public class Employee
{
    //instance variable or class variable
    private String emp_name;



    /** Constructor
     * Parameterized constructor to initialize employee name
     * @param name the name of employee we need to give
     */
    public Employee(String name)
    {
        this.emp_name=name;
    }

    /** Method
     * This method is used to give you employee name in the current object
     * @return the employee name of current object
     */
    public String getName()
    {
        return emp_name;
    }

}

class Main
{
    public static void main(String[] args)
    {
        Employee employee=new Employee("Ramesh");
        System.out.println(employee.getName());
        Employee employee1=new Employee("Suresh");
        System.out.println(employee1.getName());
    }
}