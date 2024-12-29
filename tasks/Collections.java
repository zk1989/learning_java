import java.util.ArrayList;
import java.util.Arrays;


public class Collections {
    public static void main(String[] args) {

    String[] names = new String[]{"Ala", "Ola", "Asia", "Basia", "Asia", "Ola", "Ela", "Ela", "Ewa", "Ala"};

    ArrayList<String> namesList = new ArrayList<String>(Arrays.asList(names));

    // the simpler alternative of using Arrays.asList would be:
    // for (String name : names) {
    //     namesList.add(name);
    // }

    System.out.println(namesList);

    // getting 3rd element from the list
    System.out.println(namesList.get(2));

    // checking if list contains provided element
    System.out.println(namesList.contains("Ola"));

    // removing
    namesList.remove("Ola");
    System.out.println(namesList);

    }
}