public class DemoKlasse {
    private int wert;

    public DemoKlasse(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return this.wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public DemoKlasse addieren(DemoKlasse obj) {
        return new DemoKlasse(this.wert + obj.wert);
    }

    public static void main(String[] args) {
        DemoKlasse lhs = new DemoKlasse(1);
        DemoKlasse rhs = new DemoKlasse(-5);
        DemoKlasse sum = lhs.addieren(rhs);

        System.out.println("lhs: " + lhs.getWert());
        System.out.println("rhs: " + rhs.getWert());
        System.out.println("sum: " + sum.getWert());

        System.out.println();

        lhs.setWert(5);
        System.out.println("lhs': " + lhs.getWert());
    }
}
