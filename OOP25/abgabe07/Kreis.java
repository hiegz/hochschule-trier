public class Kreis extends GeomObject {
    private int d;

    public Kreis(int x, int y, int d) {
        super(x, y);
        this.d = d;
    }

    @Override
    public void print() {
        System.out.print("Kreis");
    }

    public static void main(String[] args) {
        GeomObject kreis = new Kreis(5, 5, 20);
        kreis.print();
        System.out.println();
    }
}
