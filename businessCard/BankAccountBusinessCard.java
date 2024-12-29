import java.util.ArrayList;

public class BankAccountBusinessCard extends BusinessCardOOP {

    private String bankAccount;

    public BankAccountBusinessCard(String name, String surname, int phone, String city, String bankAccount) {
        super(name, surname, phone, city);
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public ArrayList<String> getLines() {
        ArrayList<String> getInitialLines = super.getLines();

        getInitialLines.add(bankAccount);
        
        return getInitialLines;
    }
}