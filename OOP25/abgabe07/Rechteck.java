public class Rechteck extends GeomObject {
    private int l;
    private int b;

    public Rechteck(int x, int y, int l, int b) {
        super(x, y);
        this.l = l;
        this.b = b;
    }

    @Override
    public void print() {
        System.out.print("Rechteck");
    }

    public static void main(String[] args) {
        GeomObject rechteck = new Rechteck(5, 5, 10, 10);
        rechteck.print();
        System.out.println();
    }
}
