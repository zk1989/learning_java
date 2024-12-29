// type casting (rzutowanie) - applies only to primitve types

public class Triangle {
    public static void main(String[] args) {
        int a = 5;
        int h = 3;
        double x = (double)a;
        double y = (double)h;

        double triangle = x * y / 2;

        System.out.println(triangle);

        if (triangle > 7) {
            System.out.println("Duzy trojkat");
        }
        else {
            System.out.println("Maly trojkat");
        }
    }
}