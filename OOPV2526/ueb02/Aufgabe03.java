public class Aufgabe03 {
    // From Wikipedia:
    //
    // An astronomical year lasts slightly less than 365 + 1/4 days. The historic
    // Julian calendar has three common years of 365 days followed by a leap year of
    // 366 days, by extending February to 29 days rather than the common 28. The
    // Gregorian calendar, the world's most widely used civil calendar, makes a
    // further adjustment for the small error in the Julian algorithm; this extra
    // leap day occurs in each year that is a multiple of 4, except for years evenly
    // divisible by 100 but not by 400. Thus 2000 and 2400 are leap years, but not
    // 1700, 1800, 1900, 2100, 2200, and 2300.
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    enum Month {
        January,
        Februrary,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December;

        public int numberOfDaysAtYear(int year) throws Exception {
            switch (this) {
                case January:
                case March:
                case May:
                case July:
                case August:
                case October:
                case December:
                    return 31;

                case April:
                case June:
                case September:
                case November:
                    return 30;

                case Februrary:
                    if (isLeapYear(year))
                        return 29;

                    return 28;

                default:
                    throw new Exception("unreachable");
            }
        }
    }

    public static void main(String[] args) {
        assert (isLeapYear(2000) == true);
        assert (isLeapYear(2400) == true);
        assert (isLeapYear(1700) == false);
        assert (isLeapYear(1800) == false);
        assert (isLeapYear(1900) == false);
        assert (isLeapYear(2100) == false);
        assert (isLeapYear(2200) == false);
        assert (isLeapYear(2300) == false);

        try
        {
            assert (Month.Februrary.numberOfDaysAtYear(2025) == 28);
            assert (Month.Februrary.numberOfDaysAtYear(2024) == 29);
        }
        catch (Exception ignore) { }
    }
}
