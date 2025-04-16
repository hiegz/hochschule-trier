public class A11 {
    public static void main(String[] args) {
        assert original(2, 2, 2) == alternative(2, 2, 2);
        assert original(1, 2, 2) == alternative(1, 2, 2);
        assert original(2, 2, 4) == alternative(2, 2, 4);
        assert original(3, 2, 4) == alternative(3, 2, 4);
        assert original(3, 2, 1) == alternative(3, 2, 1);
    }

    static double original(int x, int y, int z) {
        return x >= y && x <= z ? z - y : x < y ? 0 : 1.0E25;
    }

    static double alternative(int x, int y, int z) {
        double ret;
        if (x >= y && x <= z)
            ret = z - y;
        else if (x < y)
            ret = 0;
        else
            ret = 1.0E25;

        return ret;
    }
}
