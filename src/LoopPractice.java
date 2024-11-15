import java.util.Scanner;

public class LoopPractice {
    private static boolean classNotes = false;

    // The main method for the Loop Practice java class.
    public static void main(String[] args) {
        // Class notes
        if (classNotes) {
            stringManipulation();
        }

        // Create new scanner object.
        Scanner scanner = new Scanner(System.in);

        // Check if a number is prime.
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // A boolean if a number is prime. Set to true by default.
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false; // If the number is equal to or less than 1, the number is not prime, obviously.
        } else { // Otherwise, check a real number (a number greater than 1) to see if it's prime.
            for (int i = 2; i <= Math.sqrt(number); i++) { // Enter a loop, starting at i = 2 (the "first" even number), and once I is less than or equal to the sqrt of number, exit the loop.
                if (number % i == 0) { // If number mod i equals 0, the number is not prime, exit the loop.
                    isPrime = false;
                    break; // Exit loop early if not prime
                }
            }
        }

        // If number is prime, print the number is prime to console
        // Otherwise, print that then number is not prime.
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        // Find primes between two numbers
        // Prompt the user to enter the lower bound.
        System.out.print("Enter the lower bound: ");
        // Create lower integer, assign it to the users next input.
        int lower = scanner.nextInt();
        // Create upper integer, assign it to the users next input.
        System.out.print("Enter the upper bound: ");
        int upper = scanner.nextInt();

        // Print the starting message before doing the math.
        System.out.println("Prime numbers between " + lower + " and " + upper + ":");

        // Same thing as before
        for (int num = lower; num <= upper; num++) {
            boolean isPrimeInRange = true;

            if (num <= 1) {
                isPrimeInRange = false;
            } else {
                // Same thing as before
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrimeInRange = false;
                        break; // Exit loop early if not prime
                    }
                }
            }

            // If the prime number is in range, print it.
            if (isPrimeInRange) {
                System.out.print(num + " ");
            }
        }
    }

    // Class notes
    private static void stringManipulation() {
        // String .substring method - Retrieves a particular portion of a String
        // String .equals method - Compares the content of two Strings
        // String .length method - Returns the length of a String
        // for loop - allows us to repeat a task multiple times using a loop control variable

        String word = "sunflower";
        String sub = "lower";
        boolean found = false;

        for (int i = 0; i <= word.length() - sub.length(); i++) {
            String portion = word.substring(i, i + sub.length());
            if (portion.equals(sub)) {
                found = true;
            }
        }

        if (found) {
            System.out.println("We found the smaller String!");
        } else {
            System.out.println("We did not find the smaller String.");
        }

        // ***---*** //
        word = "supercalifragilisticexpialidocious";

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u")) {
                count++;
            }
        }

        System.out.println("Found " + count + " vowels in "+ word + ".");

        // ***---*** //
        String original = "backwards";
        String reversed = "";
        for (int i = 0; i < original.length(); i++) {
            String single = original.substring(i, i + 1);
            reversed = single + reversed;
        }
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);

        // ***---*** //
        for (int outer = 1; outer <= 4; outer++) {
            for (int inner = 1; inner < 3; inner++) {
                System.out.println(inner + " ");
            }
            System.out.println();
        }

        // ***---*** //
        // Nested iterations are loops inside of loops.
        // In other words, a for loop inside a for loop / a while loop inside a while loop.
        for (int outer = 1; outer < 5; outer++) {
            for (int inner = 1; inner <= outer; inner++) {
                System.out.println("*");
            }
            System.out.println();
        }

        // ***---*** //
        for (int inner = 1; inner < 3; inner++) {
            for (int outer = 1; outer < 5; outer++) {
                System.out.print(outer + " ");
            }
            System.out.println();
        }

        int result = 0;
        int k = 0;
        while (k < 4) {
            int m = 0;
            while (m < 3) {
                result++;
                m++;
            }
            k++;
        }
        System.out.println(result);
    }
}