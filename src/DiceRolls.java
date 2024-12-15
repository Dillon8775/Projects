public class DiceRolls {

    public static void main(String[] args) {
        // Print out dice 1, dice 2, and dice 3 column.
        System.out.printf("%-10s%-10s%-10s%n", "Dice 1", "Dice 2", "Total");

        // Loop to roll dice 5 times
        for (int i = 1; i <= 5; i++) {
            int dice1 = (int)(Math.random() * 6) + 1; // Generates a random number between 1 and 6
            int dice2 = (int)(Math.random() * 6) + 1; // Generates a random number between 1 and 6
            int total = dice1 + dice2;

            // Print the results of each roll
            System.out.printf("%-10d%-10d%-10d%n", dice1, dice2, total);
        }
    }
}