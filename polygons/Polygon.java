import java.util.ArrayList;

public abstract class Polygon {
    public ArrayList<Integer> sides = new ArrayList<>();

    public int perimeter() {
        int sum = 0;
        for (int side : sides) {
            sum += side;
        }
        return sum;
    }

    public abstract double surface();
}
