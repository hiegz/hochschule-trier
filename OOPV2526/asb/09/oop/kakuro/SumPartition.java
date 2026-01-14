package oop.kakuro;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SumPartition
{
    public static List<int[]> computeSummands(int sum, int n)
    {
        return computeSummandsRecursive(sum, n, 1);
    }

    private static List<int[]> computeSummandsRecursive(int sum, int n, int lo)
    {
        if (n == 0 || (n == 1 && sum < lo) || (n == 1 && sum < 0 && sum > 10))
        {
            return Arrays.asList();
        }

        if (n == 1 && sum > 0 && sum < 10)
        {
            return Arrays.asList(new int[]{sum});
        }

        List<int[]> result = new ArrayList<>();

        for (int i = lo; i < 10; ++i)
        {
            List<int[]> components = computeSummandsRecursive(sum - i, n - 1, i + 1);
            for (var component : components)
            {
                int[] summanden = new int[n];
                summanden[0] = i;
                System.arraycopy(component, 0, summanden, 1, n - 1);
                result.add(summanden);
            }
        }

        return result;
    }
}
