public class Rectangle extends Polygon {

    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
        sides.add(a);
        sides.add(b);
        sides.add(a);
        sides.add(b);
    }

    public Rectangle() {
    }

    public double surface() {
        return a * b;
    }
}
