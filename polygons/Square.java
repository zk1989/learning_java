public class Square extends Rectangle {

    private int a;

    public Square(int a) {
        this.a = a;
        sides.add(a);
        sides.add(a);
        sides.add(a);
        sides.add(a);
    }

    public double surface() {
        return a * a;
    }
}
