package oop.counter;

public class Decrementer
{
    private int value;

    public Decrementer(int counter)
    {
        this.value = counter;
    }

    public void decrement()
    {
        this.value--;
    }

    public int getValue()
    {
        return this.value;
    }
}
