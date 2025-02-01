import java.util.ArrayList;
import java.util.List;


public class Account {
    String name;
    String surname;
    List<Ticket> tickets = new ArrayList<>();

    public Account(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addTicket(Ticket ticket) { tickets.add(ticket); }

    public List<Ticket> getTickets() {
        return tickets;
    }
}