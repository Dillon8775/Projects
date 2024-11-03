import java.util.Scanner;

public class LoopPractice {
    private static boolean classNotes = false;

    // The main method for the Loop Practice java class.
    public static void main(String[] args) {
        // Class notes
        if (classNotes) {
            stringManipulation();
        }

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to input a number
        System.out.print("Enter a number:\n>>>");
        int number = input.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is NOT a prime number.");
        }

        System.out.print("Enter a lower bound:\n>>>");
        int lower = input.nextInt();
        System.out.print("Enter a upper bound:\n>>>");
        int upper = input.nextInt();

        System.out.println("Prime numbers between " + lower + " and " + upper + ":");
        for (int i = lower; i <= upper; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
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