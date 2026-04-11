package college.arrays;

import java.util.ArrayList;
import java.util.Scanner;

// Dillon C. Strickland
// February 16th, 2025
// Working with ArrayLists, adding and removing variables from the list, getting the list size, which in the end, produces a list of names.
public class ArrayListLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // a) Create an ArrayList of type String
        ArrayList<String> names = new ArrayList<>();

        // a) Prompt user for three names and add them
        System.out.println("Please enter three names:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }

        // b) Print message with number of elements using size()
        System.out.println("The list now contains " + names.size() + " elements.");

        // c) Prompt for two more names and print size again
        System.out.println("\nPlease enter two more names:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter name: ");
            names.add(scanner.nextLine());
        }
        System.out.println("The list now contains " + names.size() + " elements.");

        // d) Use a loop to print all names
        System.out.println("\nCurrent names in the list:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("- " + names.get(i));
        }

        // e) Ask for a name to remove and use an ENHANCED for loop to print
        System.out.print("\nEnter a name to remove: ");
        String nameToRemove = scanner.nextLine();
        names.remove(nameToRemove);

        System.out.println("Updated list after removal:");
        for (String name : names) {
            System.out.println("- " + name);
        }

        scanner.close();
    }
}