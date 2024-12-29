import java.lang.Math;
import java.util.Scanner;


public class MarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total number of student's marks:");
        int numberOfMarks = scanner.nextInt();
        
        int[] marks = new int[numberOfMarks];
        
        for (int i = 0; i < numberOfMarks; i++) {
            System.out.println("Enter mark:");
            int enteredMark = scanner.nextInt();
            marks[i] = enteredMark;
        }

        System.out.println("Marks average is: " + marksAverage(marks));
        System.out.println("The highest mark is: " + highestMark(marks));
    }

    public static double marksAverage(int[] marks) {
        int sum = 0;
    
        for(int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
    
        return sum / (double)marks.length;
    }

    public static int highestMark(int[] marks) {
        int highestMark = 0;
    
        for(int i = 0; i < marks.length; i++) {
            highestMark = Math.max(marks[i], highestMark);
        }
    
        return highestMark;
    }
}
