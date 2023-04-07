package com.java.concurrency.thread.locale;

public class ThreadLocale implements Runnable
{
    /**
     * Created an instance threadLocal string variable to
     * understand about it.
     */
    private ThreadLocal<String> name;
    private int counter=0;

    public ThreadLocale(String name)
    {
        this.name=new ThreadLocal<>();
        this.name.set(name);
    }

    public String getName()
    {
        return name.get();
    }

    /**
     * Method explanation :-
     * The run method has a monitor lock, that is object-level lock("this"), they are two conditions
     * here when counter is 0 and counter is equal to 1, in both the condition first we will get the
     * Threadlocal string variable to check whether each thread has copy of ThreadLocal variable or
     * not which is mentioned in the documentation, and then we change the value of that ThreadLocal
     * variable to check the final value will be change or not after all the threads are executed
     * Threadlocal working :-
     * When a new thread tries to access a threadlocal variable for the "first time" it will create a
     * new instance of the threadlocal variable for the new thread and the initial value will be null.
     *<p>
     *     So In our case when multiple threads starts executing with the target object of {@link ThreadLocale}  class then
     *     every time the new thread that executes the run method here would create new instance of {@link #name} variable and
     *     assigned the initial value as null if you have not set the value.
     *</p>
     *
     */
    @Override
    public void run()
    {
        synchronized (this) {
            if (counter == 0) {
                System.out.println("Before : "+Thread.currentThread().getName() + " : " + this.getName());
                name.set("Ramesh");
                System.out.println("After : "+Thread.currentThread().getName() + " : " + this.getName());
                counter = 1;
            } else if (counter == 1) {
                System.out.println("Before : "+Thread.currentThread().getName() + " : " + this.getName());
                name.set("Suresh");
                System.out.println("After : "+Thread.currentThread().getName() + " : " + this.getName());
                counter = 0;
            }
        }
    }
}
