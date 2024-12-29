import java.util.Scanner;


public class BusinessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter surname:");
        String surname = scanner.next();
        System.out.println("Enter phone number:");
        String tel = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();

        String nameAndSurname = "* " + name + " " + surname;
        String telAndCity = "* tel. " + tel + " adres: " + city;
        String longerLine = "";
        
        if (nameAndSurname.length() > telAndCity.length()) {
            longerLine = nameAndSurname;
        } else {
            longerLine = telAndCity;
        }

        String stars = "";
        while (stars.length() < longerLine.length()) {
            stars += "*";
        }

        // alternatywnie do powyzszego while:
        // for(int step=0; step < telAndCity.length(); step++) {
        //     System.out.print("*");
        // }

        // String stars = "*".repeat(telAndCity.length())

        String longStars = stars + "**";
        String spacesName = " ".repeat((longStars.length() - 1) - nameAndSurname.length());
        String spacesTel = " ".repeat((longStars.length() -1) - telAndCity.length());

        System.out.println(longStars);
        System.out.println(nameAndSurname + spacesName + "*");
        System.out.println(telAndCity + spacesTel + "*");
        System.out.println(longStars);

    }
}