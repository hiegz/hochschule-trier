package oop.expressgen;

public class RecursiveExpression
{
    public static String generateExpression(int n)
    {
        if (n < 0)
        {
            return String.format("-%s", generateExpression(-n));
        }

        if (n < 3)
        {
            return Integer.toString(n);
        }

        if (n % 2 == 0)
        {
            return String.format("2 * %s", generateExpression(n / 2));
        }

        return String.format("(%s + 1)", generateExpression(n - 1));
    }
}
