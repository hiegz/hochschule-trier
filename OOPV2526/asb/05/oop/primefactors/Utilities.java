package oop.primefactors;

import java.util.List;
import java.util.ArrayList;

public class Utilities
{
    public static List<Integer> getPrimeFactors(int num)
    {
        if (num <= 0)
        {
            throw new IllegalArgumentException();
        }

        if (num == 1)
        {
            return new ArrayList<>();
        }

        List<Integer> factors = new ArrayList<>();

        while (num % 2 == 0)
        {
            factors.add(2);
            num /= 2;
        }

        for (int i = 3; i * i <= num; i += 2)
        {
            while (num % i == 0)
            {
                factors.add(i);
                num /= i;
            }
        }

        if (num > 1)
        {
            factors.add(num);
        }

        return factors;

    }

    public static int gcd(int a, int b)
    {
        if (a <= 0 || b <= 0)
        {
            throw new IllegalArgumentException();
        }

        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm(int a, int b)
    {
        if (a <= 0 || b <= 0)
        {
            throw new IllegalArgumentException();
        }
        a = Math.abs(a);
        b = Math.abs(b);
        return (a / gcd(a, b)) * b;
    }
}
