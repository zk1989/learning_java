public class Screening {
    String movie;
    String datetime;
    int bookedTickets;
    Room room;

    public Screening(String movie, String datetime, int bookedTickets, Room room) {
        this.movie = movie;
        this.datetime = datetime;
        this.bookedTickets = bookedTickets;
        this.room = room;
    }

    public void setBookedTickets(int bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public void reserveSeats(int seatsQuantity, Account username) {
        int availableSeats = room.getCapacity() - this.bookedTickets;
        if (availableSeats >= seatsQuantity) {
            setBookedTickets(this.bookedTickets + seatsQuantity);
            Ticket reservation = new Ticket(seatsQuantity, this.movie, this.datetime);
            username.addTicket(reservation);
            System.out.println("You reserved " + seatsQuantity + " seats for " + this.movie + " on " + this.datetime);
        } else {
            System.out.println("There is less seats available than what you request!");
        }
    }

    public void reserveSeats(int seatsQuantity) {
        int availableSeats = room.getCapacity() - this.bookedTickets;
        if (availableSeats >= seatsQuantity) {
            setBookedTickets(this.bookedTickets + seatsQuantity);
            System.out.println("You reserved " + seatsQuantity + " seats for " + this.movie + " on " + this.datetime);
        } else {
            System.out.println("There is less seats available than what you request!");
        }
    }
}