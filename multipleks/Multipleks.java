import java.util.ArrayList;
import java.util.List;


public class Multipleks {
    String name;
    String address;
    List<Cinema> cinemas = new ArrayList<>();
    List<Account> accounts = new ArrayList<>();

    public Multipleks(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addCinema(Cinema cinema) { cinemas.add(cinema); }

    public void addAccount(Account account) { accounts.add(account); }

}