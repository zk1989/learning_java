import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Multipleks helios = new Multipleks("Helios", "Kosciuszki");

        Account janKowalski = new Account("Jan", "Kowalski");
        Account annaNowak = new Account("Anna", "Nowak");

        Cinema atlantic = new Cinema("Atlantic", "Pilsudskiego");
        Cinema solaris = new Cinema("Solaris", "Spokojna");

        Room roomA = new Room("Room A", 30, true, true);
        Room roomB = new Room("Room B", 20, false, false);
        Room roomC = new Room("Room C", 50, false, false);

        Screening jamesBond = new Screening("James Bond", "2025-02-07 18:00", 0, roomA);
        Screening pocahontas = new Screening("Pocahontas", "2025-02-12 19:00", 0, roomB);
        Screening milosc = new Screening("Milosc", "2025-02-10 15:30", 0, roomC);
        Screening milosc2 = new Screening("Milosc", "2025-02-15 08:00", 0, roomA);

        helios.addCinema(atlantic);
        helios.addCinema(solaris);

        helios.addAccount(janKowalski);
        helios.addAccount(annaNowak);

        atlantic.addRoom(roomA);
        atlantic.addRoom(roomB);
        solaris.addRoom(roomA);
        solaris.addRoom(roomC);

        atlantic.addScreening(jamesBond);
        atlantic.addScreening(pocahontas);
        solaris.addScreening(milosc);
        solaris.addScreening(milosc2);

        atlantic.printProgramme();
        solaris.printProgramme();

        Screening pocahontasScreening = atlantic.getScreenings().get(1);
        pocahontasScreening.reserveSeats(10);
        pocahontasScreening.reserveSeats(5, janKowalski);

        Screening miloscScreening = solaris.getScreenings().getFirst();
        miloscScreening.reserveSeats(2, annaNowak);

        List<Ticket> myTickets = janKowalski.getTickets();
        for (Ticket ticket : myTickets) {
            System.out.println("Movie: " + ticket.movie + "\nDate watched: " + ticket.datetime + "\nSeats booked: " + ticket.numberOfSeats);
        }
    }
}