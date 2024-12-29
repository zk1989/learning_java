import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.lang.Math;


public class DateGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz jedna z dostepnych opcji: 1 - recznie podana data 2 - losowa data");
        int choice = scanner.nextInt();
        
        LocalDate yourDate = switch(choice) {
            case 1 -> loadUserDate();
            case 2 -> loadRandomDate();
            default -> null;
        };

        if (yourDate != null) {
            System.out.println(yourDate);
        } else {
            System.out.println("Nie ma takiej opcji.");
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate datesDifference = currentDate
        .minus(Period.ofYears(yourDate.getYear()))
        .minus(Period.ofMonths(yourDate.getMonthValue()))
        .minus(Period.ofDays(yourDate.getDayOfMonth()));
        System.out.println(datesDifference);
    }

    public static LocalDate loadUserDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dzien:");
        int day = scanner.nextInt();
        System.out.println("Podaj miesiac:");
        int month = scanner.nextInt();
        System.out.println("Podaj rok:");
        int year = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }

    public static LocalDate loadRandomDate() {
        int randomDay = generateRandomNumber(1, 28);
        int randomMonth = generateRandomNumber(1, 12);
        int randomYear = generateRandomNumber(1900, 2016);

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

    public static int generateRandomNumber(int from, int to) {
        Random random = new Random();
        int randomNumber = random.nextInt(from, to);
        return randomNumber;
    }
}