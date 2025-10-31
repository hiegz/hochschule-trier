import java.util.Collection;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Abstrakte Basisklasse für ein MapReduce-Framework. Die Implementierungen der
 * Methoden
 * map, shuffle und reduce sind hier noch offengelassen; diese werden in einer
 * Unterklasse
 * umgesetzt.
 *
 * @param <K1> Typ der Schlüssel (Keys) in der Eingabe des Mappers
 * @param <V1> Typ der Werte (Values) in der Eingabe des Mappers
 * @param <K2> Typ der Schlüssel (Keys) in der Ausgabe des Mappers
 * @param <V2> Typ der Werte (Values) in der Ausgabe des Mappers
 * @param <K3> Typ der Schlüssel (Keys) in der Ausgabe des Reducers
 * @param <V3> Typ der Werte (Values) in der Ausgabe des Reducers
 */
public abstract class MapReduce<K1, V1, K2, V2, K3, V3> {
    private InputProvider<K1, V1> input;
    private OutputConsumer<K3, V3> output;
    private MapperFunction<K1, V1, K2, V2> mapperFunction;
    private ReducerFunction<K2, V2, K3, V3> reducerFunction;

    /**
     * Konstruiert ein {@link MapReduceImpl}-Objekt, indem die verschiedenen
     * Beteiligten
     * hineingereicht werden. Man könnte diese auch erst in
     * {@link MapReduceImpl#run()}
     * übergeben, das würde aber überall sehr viele Typparameter erfordern.
     *
     * @param input           ein {@link InputProvider}
     * @param mapperFunction  eine {@link MapperFunction}
     * @param reducerFunction eine {@link ReducerFunction}
     * @param output          ein {@link OutputConsumer}
     */
    public MapReduce(InputProvider<K1, V1> input, MapperFunction<K1, V1, K2, V2> mapperFunction,
            ReducerFunction<K2, V2, K3, V3> reducerFunction, OutputConsumer<K3, V3> output) {
        this.input = input;
        this.mapperFunction = mapperFunction;
        this.reducerFunction = reducerFunction;
        this.output = output;
    }

    /**
     * Der eigentliche Ablauf des MapReduce-Frameworks, d. h. Map-Shuffle-Reduce.
     *
     * Wird hier in einer sehr vereinfachten Form umgesetzt: alles im Hauptspeicher,
     * Übergabe als Collection statt als Stream, Zwischenergebnisse werden
     * materialisiert usw.
     */
    public void run() {
        try {
            mapReduce(input, mapperFunction, reducerFunction, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param input           ein {@link InputProvider}, aus dem die Eingabedaten
     *                        für den Mapper kommen
     * @param mapperFunction  eine {@link MapperFunction}, in der die eigentliche
     *                        Geschäftslogik steckt
     * @param reducerFunction eine {@link ReducerFunction}, in der die eigentliche
     *                        Geschäftslogik steckt
     * @param output          ein {@link OutputConsumer}, der die Ausgaben des
     *                        Reducers entgegennimmt
     * @throws Exception falls etwas schiefgeht
     */
    private void mapReduce(
            InputProvider<K1, V1> input,
            MapperFunction<K1, V1, K2, V2> mapperFunction,
            ReducerFunction<K2, V2, K3, V3> reducerFunction,
            OutputConsumer<K3, V3> output) throws Exception {
        Collection<Pair<K1, V1>> inputData = input.get();
        Collection<Pair<K2, V2>> mapResults = map(inputData, mapperFunction);
        Map<K2, List<V2>> shuffleResults = shuffle(mapResults);
        Collection<Pair<K3, V3>> outputData = reduce(shuffleResults, reducerFunction);
        outputResults(outputData, output);
    }

    /*
     * Man könnte das Ganze kompakter so schreiben; oben sind zur Übersicht aber die
     * Zwischenergebnisse mit ihren jeweiligen Datentypen dargestellt.
     *
     * Hier ist vielleicht der Ablauf input → map → shuffle → reduce → output besser
     * zu sehen (?).
     */
    @SuppressWarnings("unused")
    private void mapReduceCompact(
            InputProvider<K1, V1> input,
            MapperFunction<K1, V1, K2, V2> mapperFunction,
            ReducerFunction<K2, V2, K3, V3> reducerFunction,
            OutputConsumer<K3, V3> output) throws Exception {
        outputResults(reduce(shuffle(map(input.get(), mapperFunction)), reducerFunction), output);
    }

    /**
     * Gibt die Resultate aus
     *
     * @param outputData
     * @param output2
     */
    private void outputResults(Collection<Pair<K3, V3>> outputData, OutputConsumer<K3, V3> output) {
        outputData.forEach(output::consume);
    }

    // Die Methode ab hier sind in einer konkreten Unterklasse zu implementieren.

    /**
     * Wendet die {@link MapperFunction} auf die Eingabedaten an.
     *
     * @param input          ein {@link InputProvider}
     * @param mapperFunction eine {@link MapperFunction}
     * @return die Resultate der mapperFunction
     */
    protected abstract Collection<Pair<K2, V2>> map(Collection<Pair<K1, V1>> input,
            MapperFunction<K1, V1, K2, V2> mapperFunction);

    /**
     * Gruppiert die Ausgabe des Mappers nach Schlüsseln, so dass sie dem Reducer
     * übergeben werden kann.
     *
     * @param mapResults die Ausgabe des Mappers
     * @return die nach Schlüsseln gruppierte Ausgabe des Mappers
     */
    protected abstract Map<K2, List<V2>> shuffle(Collection<Pair<K2, V2>> mapResults);

    /**
     * Wendet die {@link ReducerFunction} auf die Ausgabe des Shuffle-Schrittes an.
     *
     * @param shuffleResults  die Resultate des Shuffle-Schrittes
     * @param reducerFunction die {@link ReducerFunction}
     * @return eine {@link Collection} von Ausgabepaaren
     */
    protected abstract Collection<Pair<K3, V3>> reduce(Map<K2, List<V2>> shuffleResults,
            ReducerFunction<K2, V2, K3, V3> reducerFunction);

    public static void main(String[] args) {
        // @formatter:off
        new MapReduceImpl<Integer, String, String, Integer, String, Integer>(
            new FileInputProvider("MapReduceText.txt"),
            new WordCountMapperFunction(),
            new WordCountReducerFunction(),
            new PrintingOutputConsumer<String, Integer>()
        ).run();
        // @formatter:on
    }
}

public class MapReduceImpl<K1, V1, K2, V2, K3, V3> extends MapReduce<K1, V1, K2, V2, K3, V3> {
    public MapReduceImpl(
            InputProvider<K1, V1> input,
            MapperFunction<K1, V1, K2, V2> mapperFunction,
            ReducerFunction<K2, V2, K3, V3> reducerFunction,
            OutputConsumer<K3, V3> output) {
        super(input, mapperFunction, reducerFunction, output);
    }

    @Override
    public Collection<Pair<K2, V2>> map(Collection<Pair<K1, V1>> input, MapperFunction<K1, V1, K2, V2> mapperFunction) {
        Collection<Pair<K2, V2>> result = new ArrayList<>();
        for (Pair<K1, V1> pair : input) {
            result.addAll(mapperFunction.map(pair));
        }
        return result;
    }

    @Override
    public Map<K2, List<V2>> shuffle(Collection<Pair<K2, V2>> mapResults) {
        Map<K2, List<V2>> result = new HashMap<>();
        for (Pair<K2, V2> pair : mapResults) {
            result.putIfAbsent(pair.key(), new ArrayList<V2>());
            result.get(pair.key()).add(pair.value());
        }
        return result;
    }

    @Override
    public Collection<Pair<K3, V3>> reduce(Map<K2, List<V2>> shuffleResults,
            ReducerFunction<K2, V2, K3, V3> reducerFunction) {
        Collection<Pair<K3, V3>> result = new ArrayList<>();
        for (Map.Entry<K2, List<V2>> entry : shuffleResults.entrySet()) {
            result.addAll(reducerFunction.reduce(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}

/**
 * Ein Paar bestehent aus zwei Komponenten Schlüssel (Key) und Wert (Value)
 *
 * @param <K> Typ des Schlüssels (Key)
 * @param <V> Typ des Werte (Value)
 */
record Pair<K, V>(K key, V value) {
}

/**
 * Etwas, das Eingabedaten für unseren Mapper produzieren kann,
 * z. B. indem es aus einer Datei liest.
 *
 * Braucht keine eigenen Methoden; wir erben einfach
 * {@link Iterable#iterator()}.
 *
 * @param <K> Typ der Schlüssel (Keys)
 * @param <V> Typ der Werte (Values)
 */
interface InputProvider<K, V> {
    /**
     * @return eine {@link Collection} von Key-Value-Paaren
     * @throws Exception falls irgendetwas schiefgeht, z. B. I/O
     */
    Collection<Pair<K, V>> get() throws Exception;
}

/**
 * Etwas, das Ausgaben z. B. aus einem Reducer konsumiert und ausgibt.
 *
 * @param <K> Typ der Schlüssel (Keys)
 * @param <V> Typ der Werte (Values)
 */
interface OutputConsumer<K, V> {
    void consume(Pair<K, V> output);
}

/**
 * Ein {@link InputProvider}, der aus einer Datei liest. Liefert die Position
 * innerhalb der Datei als Key und die Zeile als Value.
 */
class FileInputProvider implements InputProvider<Integer, String> {
    private String fileName;

    /**
     * @param fileName der Name der Datei, die gelesen werden soll
     */
    public FileInputProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Collection<Pair<Integer, String>> get() throws IOException {
        List<Pair<Integer, String>> results = new ArrayList<>();
        int pos = 0;
        for (String line : Files.readAllLines(Path.of(fileName))) {
            results.add(new Pair<Integer, String>(pos, line));
            pos += line.length();
        }
        return results;
    }
}

/**
 * Ein {@link OutputConsumer}, der die Werte auf die Konsole ausgibt.
 *
 * @param <K> Typ des Schlüssels (Key)
 * @param <V> Typ des Werte (Value)
 */
public class PrintingOutputConsumer<K, V> implements OutputConsumer<K, V> {

    @Override
    public void consume(Pair<K, V> output) {
        System.out.printf("%s, %s\n", output.key(), output.value());
    }
}

/**
 * Eine Funktion, die im Reduce-Schritt einer MapReduce-Berechnung
 * angewendet werden kann.
 *
 * @param <Kin>  Typ der Eingabeschlüssel (Keys)
 * @param <Vin>  Typ der Eingabewerte (Values)
 * @param <Kout> Typ der Ausgabeschlüssel (Keys)
 * @param <Vout> Typ der Ausgabevalues (Values)
 */
interface ReducerFunction<Kin, Vin, Kout, Vout> {
    /**
     * @param inputKey    ein Eingabeschlüssel
     * @param inputValues eine {@link Collection} von Eingabewerten zu diesem
     *                    Schlüssel
     * @return eine {@link Collection} von Ausgabepaaren
     */
    public Collection<Pair<Kout, Vout>> reduce(Kin inputKey, Collection<Vin> inputValues);
}

class WordCountReducerFunction implements ReducerFunction<String, Integer, String, Integer> {
    public Collection<Pair<String, Integer>> reduce(String inputKey, Collection<Integer> inputValues) {
        int count = 0;
        for (Integer value : inputValues) {
            count += value;
        }
        return Collections.singletonList(new Pair<>(inputKey, count));
    }
}

/**
 * Eine Funktion, die im Map-Schritt einer MapReduce-Berechnung
 * angewendet werden kann.
 *
 * @param <Kin>  Typ der Eingabeschlüssel (Keys)
 * @param <Vin>  Typ der Eingabewerte (Values)
 * @param <Kout> Typ der Ausgabeschlüssel (Keys)
 * @param <Vout> Typ der Ausgabevalues (Values)
 */
interface MapperFunction<Kin, Vin, Kout, Vout> {
    /**
     * @param input ein Eingabepaar
     * @return eine {@link Collection} von Ausgabepaaren
     */
    public Collection<Pair<Kout, Vout>> map(Pair<Kin, Vin> input);
}

class WordCountMapperFunction implements MapperFunction<Integer, String, String, Integer> {
    @Override
    public Collection<Pair<String, Integer>> map(Pair<Integer, String> input) {
        Collection<Pair<String, Integer>> result = new ArrayList<>();
        String line = input.value();
        String[] words = line.split("\\s+");
        for (String word : words) {
            result.add(new Pair<>(word, 1));
        }
        return result;
    }
}
