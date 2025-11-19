import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers;

        // using an anonymous class
        integers = Arrays.asList(1, 3, 2, 9, 8, 7, 6, 5, 4);
        integers.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        System.out.println(integers);

        // using a lambda expression
        integers = Arrays.asList(1, 3, 2, 9, 8, 7, 6, 5, 4);
        integers.sort((x, y) -> x - y);
        System.out.println(integers);
    }
}
