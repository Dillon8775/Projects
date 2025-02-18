import java.util.Scanner;

public class RobotGrid {
    private static final int SIZE = 8; // Create a final SIZE integer for the grid.
    private static char[][] grid = new char[SIZE][SIZE]; // Initialize the grid to have size of 8. (8x8)

    private int x = 4; // The X-position of the robot. It will start at x = 4.
    private int y = 4; // The Y-position of the robot. It will start at y = 4.
    private String direction = "N"; // The direction of the Robot. Each direction is represented by the direction's first letter.
    private int speed = 500; // The speed of the robot (controlled with Thread.sleep).

    // A char character to represent which direction the robot is facing.
    private char facingNorth = '↑';
    private char facingEast = '>';
    private char facingSouth = '↓';
    private char facingWest = '<';

    // The constructor for the robot grid. This initializes the grid and the robot at the correct position.
    public RobotGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '-';
            }
        }
        grid[x][y] = facingNorth;
    }

    // Create a robot grid object, initialize it, and run it.
    public static void main(String[] args) {
        RobotGrid robotGrid = new RobotGrid();
        robotGrid.run();
    }

    // Kind of like the "main" method for our robot. This is where everything runs.
    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // While the robot is running...
        while (running) {
            printGrid();
            showMenu();
            System.out.print("What would you like to do?: ");

            if (scanner.hasNextInt()) { // Make sure that the user inputs a NUMBER, and not anything else, like a string.
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    moveRobot(); // option 1 is move the robot. The user will then be prompted how many times they want to move the robot.
                } else if (choice == 2) {
                    changeDirection(); // option 2 is change the direction of the robot.
                } else if (choice == 3) {
                    changeSpeed(); // option 3 is change the speed of the robot (or how past the grid prints per move using Thread.sleep)
                } else if (choice == 4) {
                    System.out.println("Thanks for playing!"); // and option 4 is to quit.
                    running = false;
                } else {
                    System.out.println("Please enter a valid choice (1-4).");
                }

            } else { // If the user enters anything but a number then they can try again.
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // fix infinite loop
            }
        }
        scanner.close();
    }

    // Print the grid.
    private void printGrid() {
        System.out.println("\nGRID:");
        // For each row and cell, print a space so that the grid prints correctly.
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Then just for fun I can print the exact position of the robot.
        System.out.println("Robot is at (x: " + x + ", y:" + y + "), facing " + getDirection().toLowerCase());
    }

    // The main menu for the Robot Grid. Pretty simple
    private void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Move Robot");
        System.out.println("2. Change Direction");
        System.out.println("3. Change Speed");
        System.out.println("4. Quit");
    }

    // The method to move the robot.
    private void moveRobot() {
        // Ask the user how many times they want to move the robot.
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many spaces do you want to move the robot?");
        int moveTimes = scanner.nextInt();

        // For every time the robot is supposed to move...
        for (int i = 0; i < moveTimes; i++) {
            // Set the new X and Y pos for the robot when moving.
            int newXPos = x;
            int newYPos = y;

            // Move the robot to the next position based on it's direction
            if (direction.equals("N")) {
                newXPos--;
            } else if (direction.equals("E")) {
                newYPos++;
            } else if (direction.equals("S")) {
                newXPos++;
            } else if (direction.equals("W")) {
                newYPos--;
            }

            System.out.println("Robot is on the move...");
            printGrid();

            if (isValidMove(newXPos, newYPos)) {
                grid[x][y] = '-';
                x = newXPos;
                y = newYPos;
                grid[x][y] = getRobotDirection();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    System.out.println("Movement interrupted!");
                }
            } else {
                System.out.println("You cannot leave the grid.");
            }
        }
    }

    private boolean isValidMove(int newXPos, int newYPos) {
        return newXPos >= 0 && newXPos < SIZE && newYPos >= 0 && newYPos < SIZE;
    }

    private void changeDirection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new direction (N = north, E = east, S = south, W = west");

        try {
            String newDirection = scanner.nextLine();
            newDirection = newDirection.toUpperCase();
            if (newDirection.equals("N") || newDirection.equals("E") || newDirection.equals("S") || newDirection.equals("W")) {
                direction = newDirection;
                System.out.println("Direction changed to " + getDirection());
                grid[x][y] = getRobotDirection();
            } else {
                System.out.println("You must use 0, 90, 180 or 270 as your direction input.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void changeSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new speed (in SECONDS):");

        try {
            int newSpeed = (Integer.parseInt(scanner.nextLine()) * 1000);
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

    private char getRobotDirection() {
        if (direction.equals("N")) {
            return facingNorth;
        } else if (direction.equals("E")) {
            return facingEast;
        } else if (direction.equals("S")) {
            return facingSouth;
        } else {
            return facingWest;
        }
    }

    private String getDirection() {
        if (direction.equals("N")) {
            return "North";
        } else if (direction.equals("E")) {
            return "East";
        } else if (direction.equals("S")) {
            return "South";
        } else {
            return "West";
        }
    }
}