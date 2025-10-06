package oop.counter;

public class Incrementer
{
    private int value;

    public Incrementer(int counter)
    {
        this.value = counter;
    }

    public void increment()
    {
        this.value++;
    }

    public int getValue()
    {
        return this.value;
    }
}
