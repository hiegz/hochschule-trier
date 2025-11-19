import java.util.function.Supplier;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;

public class Main {
    public static void main(String[] args) {
        IntUnaryOperator unary;

        unary = (int x) -> x + 1;
        // op = int x -> x + 1;
        unary = (x) -> x + 1;
        // op = (int x) -> x > 0;
        unary = (x) -> {
            return x + 1;
        };
        unary = x -> x + 1;
        unary = (x) -> (x > 0) ? 1 : 0;

        Supplier supplier;

        supplier = () -> 42;
        // sup = () -> return 42;
        supplier = () -> Integer.valueOf(42);
        // sup = (x) -> x * 42;

        IntBinaryOperator binary;

        // binary = int x, int y -> x + y;
        // binary = (int x, double y) -> x / y;
        binary = (x, y) -> x + y;
        binary = (x, y) -> {
            if (x > y)
                return x;
            else
                return y;
        };
        // binary = (x, y) -> x != y;
        // binary = (int x, y) -> x + y;
    }
}
