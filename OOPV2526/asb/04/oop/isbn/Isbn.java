package oop.isbn;

public class Isbn
{
    public static String generateIsbn10(String isbn)
    {
        byte[] bytes = isbn.getBytes();
        int k = 10;
        int sum = 0;

        for (int i = 0; i < bytes.length; ++i)
        {
            byte b = bytes[i];

            if (b == '-')
            {
                continue;
            }

            if (k == 1)
            {
                throw new IllegalArgumentException();
            }

            sum += k * (b - '0');
            k--;
        }

        if (k != 1)
        {
            throw new IllegalArgumentException();
        }

        final int pruefziffer = (11 - (sum % 11)) % 11;

        return isbn + "-" + (pruefziffer == 10 ? 'X' : Integer.toString(pruefziffer));
    }

    public static String generateIsbn13(String isbn)
    {
        byte[] bytes = isbn.getBytes();
        int count = 0;
        int[] sums = { 0, 0 };

        for (int i = 0; i < bytes.length; ++i)
        {
            byte b = bytes[i];

            if (b == '-')
            {
                continue;
            }

            if (count % 2 == 0)
            {
                sums[0] += (b - '0');
            }
            else
            {
                sums[1] += (b - '0');
            }

            count += 1;

            if (count > 12)
            {
                throw new IllegalArgumentException();
            }
        }

        if (count != 12)
        {
            throw new IllegalArgumentException();
        }

        final int sum = sums[0] + sums[1] * 3;
        final int pruefziffer = (10 - (sum % 10)) % 10;

        return isbn + "-" + Integer.toString(pruefziffer);
    }
}
