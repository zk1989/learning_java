import java.util.List;

public class Rectangle extends Polygon {

    public Rectangle(List<Integer> sides) {
        super(sides);
    }

    @Override
    public double surface() {
        return sides.get(0) * sides.get(1);
    }
}
