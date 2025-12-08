import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) throws IOException {
        Parser<Token> parser = new TokenParser();
        Splitter<Token> splitter = new TokenSplitter();

        var inputPath = Paths.get(args[0]);
        var outputPath = Paths.get(args[1]);
        var shouldCount = Boolean.valueOf(args[2]);
        var shouldSort = Boolean.valueOf(args[3]);

        var lines = Files
                .lines(inputPath)
                .map(line -> parser.parse(line))
                .collect(Collectors.toList());

        if (shouldCount) {
            var counter = new HashMap<Token, Integer>();

            for (var line : lines) {
                var words = splitter.split(line);

                for (var word : words) {
                    counter.merge(word, 1, Integer::sum);
                }
            }

            for (var entries : counter.entrySet()) {
                System.out.println(entries.getKey() + " " + String.valueOf(entries.getValue()));
            }
        }

        if (shouldSort) {
            lines.sort((x, y) -> x.compareTo(y));
        }

        Files.write(outputPath, lines.stream().map(Token::toString).collect(Collectors.toList()));
    }
}

interface Parser<T> {
    T parse(String s);
}

interface Splitter<T> {
    List<T> split(T element);
}

interface Token extends Comparable<Token> {
    public List<Token> split();
}

class IntegerToken implements Token {
    Integer integer;

    public IntegerToken(Integer integer) {
        this.integer = integer;
    }

    @Override
    public List<Token> split() {
        List<Token> tokens = new ArrayList<>();
        for (char ch : this.integer.toString().toCharArray()) {
            tokens.add(new IntegerToken((Integer.valueOf(ch - '0'))));
        }
        return tokens;
    }

    @Override
    public int compareTo(Token other) {
        if (other instanceof IntegerToken) {
            return this.integer.compareTo(((IntegerToken) other).integer);
        }

        if (other instanceof StringToken) {
            return String.valueOf(this.integer).compareTo(((StringToken) other).string);
        }

        // unreachable
        assert (false);

        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.integer);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntegerToken && ((IntegerToken) obj).integer.equals(this.integer);
    }

    @Override
    public int hashCode() {
        return this.integer.hashCode();
    }
}

class StringToken implements Token {
    String string;

    public StringToken(String string) {
        this.string = string;
    }

    @Override
    public List<Token> split() {
        List<Token> tokens = new ArrayList<>();
        for (String item : this.string.split("\\s+")) {
            tokens.add(new StringToken(item));
        }
        return tokens;
    }

    @Override
    public int compareTo(Token other) {
        if (other instanceof StringToken) {
            return this.string.compareTo(((StringToken) other).string);
        }

        if (other instanceof IntegerToken) {
            return this.string.compareTo(String.valueOf(((IntegerToken) other).integer));
        }

        // unreachable
        assert (false);

        return 0;
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StringToken && ((StringToken) obj).string.equals(this.string);
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }
}

class TokenParser implements Parser<Token> {
    public Token parse(String str) {
        try {
            return new IntegerToken(Integer.parseInt(str));
        } catch (NumberFormatException ex) {
            return new StringToken((String) str);
        }
    }
}

class TokenSplitter implements Splitter<Token> {
    public List<Token> split(Token token) {
        return token.split();
    }
}
