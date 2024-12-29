public class Demo {

    public static void main(String[] args) {
        Lord army1 = initArmy1();
        Lord army2 = initArmy2();

        System.out.println(army1.gatherArmy());
        System.out.println(army2.gatherArmy());

        BattleResolver resolver = new BattleResolver();
        Lord winner = resolver.getWinner(army1, army2);
        System.out.println(winner.getName());
    }

    private static Lord initArmy1() {
        Lord king1 = new Lord("Arthur the Greatest");
        king1.setKnights(100);

        Lord lord1 = new Lord("Henrik the Short-Handed");
        lord1.setKnights(5);
        king1.add(lord1);
        return king1;
    }

    private static Lord initArmy2() {
        Lord king2 = new Lord("Richard Lion Tail");
        king2.setKnights(100);

        Lord lord2 = new Lord("William Lion Nail");
        lord2.setKnights(6);
        king2.add(lord2);
        return king2;
    }
}
