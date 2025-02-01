import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Cinema {
    String name;
    String address;
    List<Room> rooms = new ArrayList<>();
    List<Screening> screenings = new ArrayList<>();

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public List<Screening> getScreenings() { return screenings; }

    public void addRoom(Room room) { rooms.add(room); }

    public void addScreening(Screening screening) { screenings.add(screening); }

    public void printProgramme() {
        System.out.println("Check out our programme for the next 7 days:");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfNextWeek = now.plusWeeks(1);
        for (Screening screening : screenings) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime screen = LocalDateTime.parse(screening.datetime, formatter);
            if (screen.isAfter(now) && screen.isBefore(endOfNextWeek)) {
                System.out.println(screening.movie + " " + screening.datetime);
            }
        }
    }
}