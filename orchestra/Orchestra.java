import java.util.LinkedList;

public class Orchestra implements Instrument {
    
    private LinkedList<Instrument> instruments = new LinkedList<>();

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public void play() {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
