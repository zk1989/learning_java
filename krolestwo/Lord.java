import java.util.List;
import java.util.ArrayList;

public class Lord {

    private int knights;
    private List<Lord> vassals = new ArrayList<>();
    private String name;

    public Lord(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }

    public int getKnights() { return knights; }

    public void setKnights(int knights) { this.knights = knights; }

    public void add(Lord vassal) { vassals.add(vassal); }

    public void remove(Lord vassal) { vassals.remove(vassal); }

    public int gatherArmy() {
        int army = this.getKnights();
        for (Lord lord : vassals) {
            army += lord.gatherArmy();
        }
        return army;
    }
}
