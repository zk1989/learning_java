public class PolygonDemo {
    public static void main(String[] args) {
        Rectangle rc1 = new Rectangle(4, 3);
        Square s1 = new Square(5);
        Triangle t1 = new Triangle(10, 6, 7);

        System.out.println(rc1.perimeter());
        System.out.println(rc1.surface());

        System.out.println(s1.perimeter());
        System.out.println(s1.surface());

        System.out.println(t1.perimeter());
        System.out.println(t1.surface());
    }
}
