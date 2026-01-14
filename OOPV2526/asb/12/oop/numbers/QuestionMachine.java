package oop.numbers;

public class QuestionMachine
{
    public static int findNumber(int lower, int upper, AnswerMachine machine)
    {
        if (machine == null || lower > upper)
        {
            throw new IllegalArgumentException();
        }

        if (lower == upper)
        {
            return lower;
        }

        int left = lower;
        int right = upper;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            GuessResult result = machine.guessNumber(mid);

            switch (result)
            {
                case HIT:
                    return mid;

                case TOO_LOW:
                    left = mid + 1;
                    break;

                case TOO_HIGH:
                    right = mid - 1;
                    break;

                case NO_ANSWER:
                default:
                    return upper + 1;
            }
        }

        return upper + 1;
    }
}
