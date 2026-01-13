package oop.hanoi;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Towers
{
    public static List<Move> computeMoves(int h)
    {
        return moveTo(h, 0, 2);
    }

    private static List<Move> moveTo(int h, int from, int to)
    {
        if (h <= 0)
        {
            throw new IllegalArgumentException();
        }

        if (h == 1)
        {
            return Arrays.asList(new Move(from, to));
        }

        List<Move> moves = new ArrayList<>();
        int intermediate = selectFreePeg(from, to);
        moves.addAll(moveTo(h - 1, from, intermediate));
        moves.add(new Move(from, to));
        moves.addAll(moveTo(h - 1, intermediate, to));
        return moves;
    }

    private static int selectFreePeg(int a, int b)
    {
        if (a == b)
        {
            throw new IllegalArgumentException();
        }

        a += 1;
        b += 1;

        return 6 - a - b - 1;
    }
}
