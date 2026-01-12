package oop.money;

import java.util.List;
import java.util.ArrayList;

public class CashDesk
{
    private static final int MULTIPLIER = 1000;
    private static final double[] SCHEINE = { 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };

    public static List<Double> pay(double preis, double bezahlt) throws IllegalArgumentException
    {
        if (preis < 0.0 || bezahlt < 0.0 || bezahlt < preis)
        {
            throw new IllegalArgumentException();
        }

        ArrayList<Double> result = new ArrayList<>();
        int wechsel = (int) (bezahlt * MULTIPLIER) - (int) (preis * MULTIPLIER);
        int i = 0;

        while (i < SCHEINE.length && wechsel > 0)
        {
            final int schein = (int) (SCHEINE[i] * MULTIPLIER);

            if (wechsel - schein >= 0)
            {
                wechsel -= schein;
                result.add(SCHEINE[i]);
                continue;
            }

            i += 1;
        }

        return result;
    }
}
