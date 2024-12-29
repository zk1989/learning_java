public class OrchestraDemo {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Flute flute = new Flute();
        Trombone trombone = new Trombone();
        Orchestra orchestra = new Orchestra();
        
        orchestra.addInstrument(guitar);
        orchestra.addInstrument(flute);
        orchestra.addInstrument(trombone);

        orchestra.play();
    }
}
