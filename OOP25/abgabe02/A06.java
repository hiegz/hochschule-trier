public class A06 {
    public static void main(String[] args) {
        final int[] as = { 0, 3, 4, 6, 7, 10, 50, -15, 11, 23 };
        for (final int a : as) {
            assert original(a) == alternative(a);
        }
    }

    static int original(int a) {
        int result;
        if (a == 3)
            result = a;
        else if (a == 6)
            result = a + 10;
        else if (a == 10)
            result = a + 20;
        else
            result = a + 30;
        return result;
    }

    static int alternative(int a) {
        int result;
        switch (a) {
            case 3:
                result = a;
                break;
            case 6:
                result = a + 10;
                break;
            case 10:
                result = a + 20;
                break;
            default:
                result = a + 30;
                break;
        }
        return result;
    }
}
