import java.util.List;

public class Triangle extends Polygon {

    public Triangle(List<Integer> sides) {
        super(sides);
    }

    @Override
    public double surface() {
        int a = sides.get(0);
        int b = sides.get(1);
        int c = sides.get(2);

        int p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}