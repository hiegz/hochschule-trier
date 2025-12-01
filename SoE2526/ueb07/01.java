import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Abteilung abteilung;
        Mitarbeiter mitarbeiter;

        // #1

        abteilung = new Abteilung();
        mitarbeiter = new Mitarbeiter();

        assert !abteilung.hasMitarbeiter(mitarbeiter);
        assert mitarbeiter.getAbteilung() == null;

        abteilung.addMitarbeiter(mitarbeiter);

        assert abteilung.hasMitarbeiter(mitarbeiter);
        assert mitarbeiter.getAbteilung() == abteilung;

        // #2

        abteilung = new Abteilung();
        mitarbeiter = new Mitarbeiter();

        assert !abteilung.hasMitarbeiter(mitarbeiter);
        assert mitarbeiter.getAbteilung() == null;

        mitarbeiter.setAbteilung(abteilung);

        assert abteilung.hasMitarbeiter(mitarbeiter);
        assert mitarbeiter.getAbteilung() == abteilung;
    }
}

class Abteilung {
    public Set<Mitarbeiter> mitarbeiterSet = new HashSet<>();

    public boolean hasMitarbeiter(Mitarbeiter mitarbeiter) {
        return mitarbeiterSet.contains(mitarbeiter);
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        if (mitarbeiterSet.add(mitarbeiter)) {
            mitarbeiter.linkAbteilung(this);
        }
    }

    public void linkMitarbeiter(Mitarbeiter mitarbeiter) {
        mitarbeiterSet.add(mitarbeiter);
    }
}

class Mitarbeiter {
    private Abteilung abteilung;

    public Abteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(Abteilung abteilung) {
        if (this.abteilung != abteilung) {
            this.abteilung = abteilung;
            if (abteilung != null) {
                abteilung.linkMitarbeiter(this);
            }
        }
    }

    public void linkAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }
}
