public abstract class GeomObject {
    protected int x;
    protected int y;

    protected GeomObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void print();
}
