package oop.collections.subsets;

import java.util.Set;
import java.util.HashSet;

public class Computation
{
    @SuppressWarnings("unchecked")
    public static<T> Set<Set<T>> computeAllSubsets(Set<T> set)
    {
        Object[] list = set.toArray();
        int n = list.length;
        int total = 1 << n;

        Set<Set<T>> result = new HashSet<>();

        for (int mask = 0; mask < total; ++mask)
        {
            Set<T> subset = new HashSet<>();

            for (int i = 0; i < n; ++i)
            {
                if ((mask & (1 << i)) != 0)
                {
                    subset.add((T)(list[i]));
                }
            }

            result.add(subset);
        }

        return result;
    }
}
