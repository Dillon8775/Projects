import java.util.Scanner;

// ROBOT GRID PROJECT
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

            // Track the robot's movement and print the grid for each move.
            System.out.println("Robot is on the move...");
            printGrid();

            // Make sure that the robot can move to the next spot by using my isValidMove method.
            // Then set the grid[x][y] (or robot) to the direction and position to correctly update it for each move.
            // I also must use InterruptedException because of the Thread.sleep call
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
                // if the grid can't move to the next position then just print out that the robot can't leave the grid.
                System.out.println("You cannot leave the grid.");
            }
        }
    }

    // This took way to long to figure out.
    private boolean isValidMove(int newXPos, int newYPos) {
        // i thought this would work but it doesn't because this isn't the correct order to check around the robot
//        return newXPos <= 0 && newYPos >= 0;
        return newXPos >= 0 && newXPos < SIZE && newYPos >= 0 && newYPos < SIZE;
    }

    // Change the direction of the robot.
    private void changeDirection() {
        Scanner scanner = new Scanner(System.in);
        // Create a new scanner to get the direction of the robot from the user.
        System.out.println("Enter new direction (N = north, E = east, S = south, W = west");

        // Using a try-catch statement, I can simply set grid[x][y] (the pos of the robot) to the new direction
        // I also need to set direction to the new direction.
        try {
            String newDirection = scanner.nextLine();
            newDirection = newDirection.toUpperCase();
            if (newDirection.equals("N") || newDirection.equals("E") || newDirection.equals("S") || newDirection.equals("W")) {
                direction = newDirection;
                System.out.println("Direction changed to " + getDirection());
                grid[x][y] = getRobotDirection();
            } else {
                // Make sure that the user enters one of these letters.
                System.out.println("You must use N, E, S or W as your direction input.");
            }
        } catch (Exception e) {
            // for if the user enters a weird character
            System.out.println("Please enter a valid input.");
        }
    }

    // Change the speed of the robot grid.
    private void changeSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new speed (in SECONDS):");

        // All I have to do here is multiply the user's input by 1,000 to make it easier for the user to enter how fast they want the robot grid to move.
        // I just have to change the speed variable here, and then use that new value with Thread.sleep
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

    // Simply returns the char direction of the robot (like the robot direction visually) based on the direction variable.
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

    // Gets the direction of the robot as a string based on the direction variable letter.
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