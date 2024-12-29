import java.util.Arrays;
import java.util.Scanner;


public class DividersCalculator {

    public static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int enteredNumber = scanner.nextInt();
        return enteredNumber;
    }

    public static boolean checkDivider(int a, int b) {
        return a % b == 0;
    }

    public static int[] findDividers(int x) {
        int[] dividers = new int[x / 2 + 1];
        
        int dividersCounter = 0;
        for (int i = 1; i <= x / 2; i++) {
            if (checkDivider(x, i)) {
                dividers[dividersCounter] = i;
                dividersCounter++;
            }
        }

        int[] foundDividers = Arrays.copyOf(dividers, dividersCounter);
        return foundDividers;
    }

    public static void printDividers(int[] foundDividers) {
        for (int i = 0; i < foundDividers.length; i++) {
            System.out.println(foundDividers[i]);
        }
    }

    public static void main(String[] args) {
        printDividers(findDividers(readNumber()));
    }
}
