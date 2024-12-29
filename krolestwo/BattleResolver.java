public class BattleResolver {

    public Lord getWinner(Lord army1, Lord army2) {
        Lord winner;
        if (army1.gatherArmy() > army2.gatherArmy()) {
            winner = army1;
        } else {
            winner = army2;
        }
        return winner;
    }
}
