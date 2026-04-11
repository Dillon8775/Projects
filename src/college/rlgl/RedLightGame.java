package college.rlgl;

import java.util.Random;
import java.util.Scanner;

public class RedLightGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get Player 1 Info
        System.out.print("Enter name for Player 1: ");
        String p1Name = input.nextLine();
        System.out.print("Enter max steps for " + p1Name + ": ");
        int p1Max = input.nextInt();

        // Get Player 2 Info
        System.out.print("Enter name for Player 2: ");
        input.nextLine(); // Clear buffer
        String p2Name = input.nextLine();
        System.out.print("Enter max steps for " + p2Name + ": ");
        int p2Max = input.nextInt();

        System.out.print("Play a regular 30-step game? (yes/no): ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("yes")) {
            // Calls Version 1 (4 parameters)
            playGame(p1Name, p1Max, p2Name, p2Max);
        } else {
            System.out.print("How many steps to the finish line? ");
            int customDistance = input.nextInt();
            // Calls Version 2 (5 parameters - Overloaded)
            playGame(p1Name, p1Max, p2Name, p2Max, customDistance);
        }
    }

    // original method
    public static void playGame(String p1, int p1Max, String p2, int p2Max) {
        // Just calls the second version with 30 as a default
        playGame(p1, p1Max, p2, p2Max, 30);
    }

    // overloaded method
    public static void playGame(String p1, int p1Max, String p2, int p2Max, int finishLine) {
        Random rand = new Random();
        int p1Total = 0;
        int p2Total = 0;

        // Loop until someone crosses the finish line
        while (p1Total <= finishLine && p2Total <= finishLine) {
            p1Total += rand.nextInt(p1Max) + 1; // Random 1 to max
            p2Total += rand.nextInt(p2Max) + 1;
        }

        // Determine the winner
        System.out.println("\n--- Results ---");
        System.out.println(p1 + " score: " + p1Total);
        System.out.println(p2 + " score: " + p2Total);

        if (p1Total > p2Total) {
            System.out.println("Winner: " + p1 + "!");
        } else if (p2Total > p1Total) {
            System.out.println("Winner: " + p2 + "!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}