import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main loop for user input
        while (true) {
            System.out.print("Enter # of blocks or (-1) to exit: ");
            int totalBlocks = scanner.nextInt();

            // Exit condition
            if (totalBlocks == -1) {
                System.out.println("Have a nice day!");
                break;
            }

            // Handle edge cases for input
            if (totalBlocks <= 0) {
                System.out.println("Please enter a positive number of blocks.");
                continue;
            }

            int layer = 0;
            int blocksUsed = 0;

            // Calculate the number of layers
            while (blocksUsed + (layer + 1) <= totalBlocks) {
                layer++;
                blocksUsed += layer;
            }

            int remainingBlocks = totalBlocks - blocksUsed;

            // Output the number of layers and remaining blocks
            System.out.println("Your total layers: " + layer);
            System.out.println("Blocks remaining: " + remainingBlocks);

            // Print the ASCII pyramid
            for (int i = 1; i <= layer; i++) {
                // Calculate the number of spaces and hashes for the current layer
                int spaces = layer - i;
                int hashes = i * 2 - 1;

                // Print the current layer
                System.out.println(" ".repeat(spaces) + "#".repeat(hashes));
            }
        }

        scanner.close();
    }
}