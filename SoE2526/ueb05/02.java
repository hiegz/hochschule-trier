import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(sumOfValues(list));
    }

    public static int sumOfValues(List<Integer> list) {
        int accumulator = 0;
        for (int item : list) {
            accumulator += item;
        }
        return accumulator;
    }
}
