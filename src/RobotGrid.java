import java.util.Scanner;

public class RobotGrid {
    private static final int SIZE = 8;
    private static char[][] grid = new char[8][8];

    private int x = 4;
    private int y = 4;
    private int direction = 0;
    private int speed = 500;

    public RobotGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
        grid[x][y] = 'R';
    }

    public static void main(String[] args) {
        RobotGrid robotGrid = new RobotGrid();
        robotGrid.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printGrid();
            showMenu();
            System.out.print("Enter choice: ");
        }

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                moveRobot();
            } else if (choice == 2) {
                changeDirection();
            } else if (choice == 3) {
                changeSpeed();
            } else if (choice == 4) {
                running = false;
            } else {
                System.out.println("Invalid choice! please enter a number 1-4.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }

        System.out.println("Game over!");
        scanner.close();
    }

    private void printGrid() {
        System.out.println("\nCurrent Grid:");
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("Robot is at (" + x + "," + y + ") facing " + getDirection());
    }

    private void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Move Robot");
        System.out.println("2. Change Direction");
        System.out.println("3. Change Speed");
        System.out.println("4. Quit");
    }

    private void moveRobot() {
        int newXPos = x;
        int newYPos = y;

        if (direction == 0) {
            newXPos--;
        } else if (direction == 90) {
            newYPos++;
        } else if (direction == 180) {
            newXPos++;
        } else if (direction == 270) {
            newYPos--;
        }

        if (isValidMove(newXPos, newYPos)) {
            grid[x][y] = '-';
            x = newXPos;
            y = newYPos;
            grid[x][y] = 'R';
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Movement interrupted!");
            }
        } else {
            System.out.println("You cannot leave the grid.");
        }
    }

    private boolean isValidMove(int newXPos, int newYPos) {
        return newXPos >= 0 && newXPos < SIZE && newYPos >= 0 && newYPos < SIZE;
    }

    private void changeDirection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new direction (0 = North, 90 = East, 180 = South, 270 = West:");

        try {
            int newDirection = Integer.parseInt(scanner.nextLine());
            if (newDirection == 0 || newDirection == 90 || newDirection == 180 || newDirection == 270) {
                direction = newDirection;
                System.out.println("Direction changed to " + getDirection());
            } else {
                System.out.println("You must use 0, 90, 180 or 270 as your direction input.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void changeSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new speed (in milliseconds.)");

        try {
            int newSpeed = Integer.parseInt(scanner.nextLine());
            if (newSpeed > 0) {
                speed = newSpeed;
                System.out.println("Speed changed to " + speed + " ms per move.");
            } else {
                System.out.println("Please enter a positive number.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private String getDirection() {
        if (direction == 0) {
            return "North";
        } else if (direction == 90) {
            return "East";
        } else if (direction == 180) {
            return "South";
        } else {
            return "West";
        }
    }
}