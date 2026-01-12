package oop.palindrom;

import java.util.Objects;

public class Palindrom
{
    public static boolean check(String input)
    {
        return Objects.equals(input, new StringBuilder(input).reverse().toString());
    }
}
