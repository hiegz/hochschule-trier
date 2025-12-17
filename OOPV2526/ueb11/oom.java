import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        long count = 0;

        try {
            List<byte[]> list = new ArrayList<>();

            while (true) {
                list.add(new byte[1024 * 1024]);
                count++;
            }
        } catch (OutOfMemoryError err) {
            System.out.println("OutOfMemoryError");
            System.out.println("Created " + count + " objects");
        }
    }
}
