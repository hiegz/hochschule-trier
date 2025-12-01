import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Abteilung> abteilungen = new ArrayList<>();
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();

        abteilungen.add(new Abteilung());
        abteilungen.add(new Abteilung());

        mitarbeiter.add(new Mitarbeiter(abteilungen.get(0)));
        mitarbeiter.add(new Mitarbeiter(abteilungen.get(0)));
        mitarbeiter.add(new Mitarbeiter(abteilungen.get(1)));
        mitarbeiter.add(new Mitarbeiter(abteilungen.get(1)));

        // @formatter:off

        assert abteilungen.get(0).getMitarbeiters(mitarbeiter).equals(Arrays.asList(mitarbeiter.get(0), mitarbeiter.get(1)));
        assert abteilungen.get(1).getMitarbeiters(mitarbeiter).equals(Arrays.asList(mitarbeiter.get(2), mitarbeiter.get(3)));
    }
}

class Abteilung {
    public List<Mitarbeiter> getMitarbeiters(List<Mitarbeiter> alleMitarbeiter) {
        return alleMitarbeiter.stream().filter(mitarbeiter -> mitarbeiter.abteilung == this).collect(Collectors.toList());
    }
}

class Mitarbeiter {
    public Abteilung abteilung;

    public Mitarbeiter() {
        this.abteilung = null;
    }

    public Mitarbeiter(Abteilung abteilung) {
        this.abteilung = abteilung;
    }
}
