public class LoginGenerator {
    public static void main(String[] args) {

        String[] studentNames = { "Budynek Piotr", 
                                  "Chalupa Krystyna", 
                                  "Wiezowiec Jan",
                                  "Szkieletor Andrzej",
                                  "Domek Marianna" };

        for (String name : studentNames) {
            String[] logins = name.toLowerCase().split("\\s");
            System.out.println(logins[1].substring(0, 3) + logins[0].substring(0, 2) + "@student.agh.edu.pl");
        }
    }
}