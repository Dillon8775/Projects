import java.util.Scanner;

public class RobotGridOLD {
    String[][] grid = {
            {"|﹊|", "|﹊|", "|﹊|", "|﹊|"},
            {"| |", "| |", "| |", "| |"},
            {"| |", "| |", "| |", "| |"},
            {"|_|_", "|_|_", "|_|_", "|_|_"}
    };

    public RobotGridOLD() {
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        RobotGridOLD grid = new RobotGridOLD();

        System.out.println("1 - Build Grid");
        System.out.println("2 - Move Robot");
        System.out.println("3 - Change Robot Direction");
        System.out.println("4 - Change Robot Speed");
        System.out.println("5 - Exit");

        grid.buildGrid();

        if (choice == 1) {

        } else if (choice == 2) {

        } else if (choice == 3) {

        } else if (choice == 4) {

        } else {

        }
    }

    private void buildGrid() {
        for (int i = 0; i < grid.length; i++) {
            // Loop through each column in the current row
            for (int j = 0; j < grid[i].length; j++) {
                // Print each element in the row, padded to 4 characters for consistent alignment
                System.out.printf("%-5s", grid[i][j]);
            }
            // After printing each row, print a newline to move to the next row
            System.out.println();
        }
    }
}