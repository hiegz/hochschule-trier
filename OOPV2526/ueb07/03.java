import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        writeStrings(Arrays.asList("a", "b", "c", "d", "e", "ab", "abc", "abcd", "abcde", "acdeb"));
    }

    static void writeStrings(List<String> strings) {
        try {
            FileWriter fWriter = new FileWriter("strings.txt");
            String result = strings.stream()
                    .filter(string -> string.length() > 4)
                    .collect(Collectors.joining(" "));
            fWriter.write(result);
            fWriter.write("\n");
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
