public class BusinessCardDemo {
    public static void main(String[] args) {
        BusinessCardOOP bc1 = new BusinessCardOOP("Jan", "Kowalski", 55, "Warszawa");
        BankAccountBusinessCard bc2 = new BankAccountBusinessCard("Zuzanna", "Kocik", 5345345, "Lublin", "5463465677");

        bc1.print();
        bc2.print();
    }
}