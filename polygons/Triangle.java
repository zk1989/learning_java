public class Triangle extends Polygon {

    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    public double surface() {
        int p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}