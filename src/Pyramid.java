import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main loop
        while (true) {
            // Prompt the user to enter the number of blocks to build the pyramid, or press -1 to exit.
            System.out.print("Enter # of blocks or (-1) to exit: ");
            // Create int total blocks and make it equal to the user's input.
            int totalBlocks = scanner.nextInt();

            // If the user enters -1, exit the program.
            if (totalBlocks == -1) {
                System.out.println("Have a nice day!");
                break;
            }

            // If the user enters a non-positive number, then prompt the user to enter a positive number.
            if (totalBlocks <= 0) {
                System.out.println("Please enter a positive number of blocks.");
                continue; // Use the continue keyword to allow the program to continue running after the user inputs a positive number of blocks.
            }

            // Create our variables used to create the pyramid, layer and blocks used.
            int layer = 0;
            int blocksUsed = 0;

            // Calculate the number of layers.
            while (blocksUsed + (layer + 1) <= totalBlocks) {
                layer++; // Layer is incremented.
                blocksUsed += layer; // Each layer is added to blocks used.
            }

            // Remaining blocks is the difference between total blocks and blocks used.
            int remainingBlocks = totalBlocks - blocksUsed;

            // Output the number of layers and remaining blocks.
            System.out.println("Your total layers: " + layer);
            System.out.println("Blocks remaining: " + remainingBlocks);

            // Print the ASCII pyramid
            // Create a for loop, where I is equal to 1, and repeat until I is less than or equal to layer, increment I as the loop continues.
            for (int i = 1; i <= layer; i++) {
                // Calculate the number of spaces and hashes for the current layer.
                int spaces = layer - i;
                int hashes = i * 2 - 1;

                // Print the current layer.
                // I found out that there is a .repeat method for strings.
                // We can use the .repeat method to print the correct number of spaces and #'s...
                // to print those characters the amount of times that int spaces and hashes are equal to.
                // I Used this to fix the spaces only printing on HALF of the pyramid.
                System.out.println(" ".repeat(spaces) + "#".repeat(hashes));
            }
        }

        // Close the scanner object to save memory.
        scanner.close();
    }
}