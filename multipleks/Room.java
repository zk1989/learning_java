public class Room {
    String name;
    int capacity;
    boolean hasVIP;
    boolean has3D;

    public Room(String name, int capacity, boolean hasVIP, boolean has3D) {
        this.name = name;
        this.capacity = capacity;
        this.hasVIP = hasVIP;
        this.has3D = has3D;
    }

    public int getCapacity() {
        return capacity;
    }
}