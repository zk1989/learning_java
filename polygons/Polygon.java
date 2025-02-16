import java.util.List;


public abstract class Polygon {

    protected List<Integer> sides;

    public Polygon(List<Integer> sides) {
        this.sides = sides;
    }

    public int perimeter() {
        int sum = 0;
        for (int side : sides) {
            sum += side;
        }
        return sum;
    }

    public abstract double surface();

}
