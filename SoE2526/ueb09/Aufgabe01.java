import java.lang.reflect.Array;

public class Program {
    public static void main(String[] args) {
        System.out.println("Person: ");
        (new Person()).tagesablauf();

        System.out.println("\nMitarbeiter:");
        (new Mitarbeiter()).tagesablauf();

        System.out.println("\nStudent:");
        (new Student()).tagesablauf();

        System.out.println("\n==========\n");

        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(1);
        arrlist.add(2);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(5);
        for (var item : arrlist.items) {
            System.out.println(item);
        }
    }
}

// Beispiel 1

class Person {
    final void tagesablauf() {
        schlafen();
        vormittag();
        essen();
        nachmittag();
        freizeit();
    }

    final void schlafen() {
        System.out.println("schlafen()");
    }

    void vormittag() {
        // ...
    }

    final void essen() {
        System.out.println("essen()");
    }

    void nachmittag() {
        // ...
    }

    final void freizeit() {
        System.out.println("freizeit()");
    }
}

class Mitarbeiter extends Person {
    @Override
    void vormittag() {
        System.out.println("arbeiten()");
    }

    @Override
    void nachmittag() {
        // ...
    }
}

class Student extends Person {
    @Override
    void vormittag() {
        System.out.println("lernen()");
    }

    @Override
    void nachmittag() {
        System.out.println("lernen()");
    }
}

// Beispiel 2

class Produzent {
}

class Adresse {
}

interface KennzahlenQuelle {
    double[] kennzahlenAbholen(Produzent p);
}

interface DiagrammAnzeige {
    void balkendiagramm(double[] werte);

    void histogramm(double[] werte);
}

interface Alarm {
    void alarmAusloesen();
}

interface Benachrichtigung {
    void mailVersenden(String inhalt, Adresse empfaenger);
}

// Beispiel 3

interface SizedList {
    int size();
}

interface GrowableList<T> extends SizedList {
    void add(T element);
}

interface ShrinkableList extends SizedList {
    void remove(int index);
}

class ArrayList<T> implements SizedList, GrowableList<T> {
    public T[] items;

    public int size() {
        return items != null ? items.length : 0;
    }

    public void add(T element) {
        @SuppressWarnings("unchecked")
        final T[] newItems = (T[]) Array.newInstance(element.getClass(), size() + 1);
        if (items != null)
            System.arraycopy(items, 0, newItems, 0, size());
        newItems[size()] = element;
        items = newItems;
    }
}
