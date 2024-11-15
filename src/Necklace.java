import java.util.Scanner;

public class Necklace {
    private static boolean classNotes = true;

    public static void main(String[] args) {
        if (classNotes) {
            loopPractice();
        }
        System.out.println("Now running the Necklace program...");

        // START OF NECKLACE PROGRAM
        // --- ///

        // Create a new scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first STARTING number.
        System.out.print("Enter the first starting number: ");
        int firstNum = scanner.nextInt();
        // Prompt the user to enter the second STARTING number.
        System.out.print("Enter the second starting number: ");
        int secondNum = scanner.nextInt();

        // Create a "duplicate" variable and assign it to the first number that the user inputted.
        int initialFirst = firstNum;
        // Create another "duplicate" variable and assign it to the second number that the user inputted.
        int initialSecond = secondNum;

        // Create a count variable, assign to 0 to start.
        int count = 0;
        // Print the user's inputted first and second number.
        System.out.print(firstNum + " " + secondNum + " ");

        while (true) {
            // Create the next num variable.
            int nextNum = (firstNum + secondNum)  % 10;
            // Print the next num variable.
            System.out.print(nextNum + " ");

            // Assign first num to second num
            firstNum = secondNum;
            // Assign second num to nextNum
            secondNum = nextNum;
            // Increment count
            count++;

            // Once firstNum and secondNum equal their original values, exit this while loop.
            if (firstNum == initialFirst && secondNum == initialSecond) {
                break;
            }
        }

        // Print out how many steps it took to close the necklace.
        System.out.println();
        System.out.println("It took " + count + " steps to close the necklace");

        // Close the scanner object to save memory.
        scanner.close();
    }

    // CLASS NOTES, NOT AT ALL RELATED TO THE NECKLACE PROGRAM.
    private static void loopPractice() {
        int count = 0;
        for (int k = 0; k < 30; k++) {
            if (k % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);

        for (int k = 0; k < 1000; k++) {
            if (k % 2 == 0) {
                System.out.println("k % 2 == 0!");
            }
        }

        // *** --- *** //
        // ACCESS MODIFIERS
        // public and private affect the access of classes, data, constructors and method.
        // They keyword private restricts access to the declaring class, while the keyword public allows access from classes outside the declaring class.
        // Classes are designated public.
        // Access to attributes should be kept internal to the class. Therefor, instance variables are designated as private.
        // Constructors are designated public.
        // Access to behaviors can be internal or external to the class. Therefor, methods can be designated as public or private.
    }
}