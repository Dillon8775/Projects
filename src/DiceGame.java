public class DiceGame {
    public static Integer game_count = 0;
    public static Double winnings = 0.0;
    private Integer roll;

    public DiceGame(int r) {
        game_count++;
        roll = r;
    }

    public void setRoll(int nr) {
        roll = nr;
    }

    public Integer getRoll() {
        return roll;
    }

    public void checkWin() {
        if (roll == 6) {
            DiceGame.winnings += 25.0;
            System.out.println("You win $25!");
        }
    }
}