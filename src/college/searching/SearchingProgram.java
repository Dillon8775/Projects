package college.searching;

import java.util.Scanner;

// Dillon Strickland
// 4/10/2026
// Searches the array to tell the user if the item is in the array or not, using both linear and binary search.
public class SearchingProgram {

    // Linear search by price
    public static boolean linearSearch(Item[] items, double targetPrice) {
        for (Item item : items) {
            if (item.getPrice() == targetPrice) {
                return true;
            }
        }
        return false;
    }

    // Binary search by UPC (array MUST be sorted by UPC)
    public static boolean binarySearch(Item[] items, int targetUPC) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (items[mid].getUpc() == targetUPC) {
                return true;
            } else if (items[mid].getUpc() < targetUPC) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Runs the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Must be sorted by UPC for binary search
        Item[] items = {
            new Item(1001, "2 lbs", 5.99),
            new Item(1002, "1 lb", 2.49),
            new Item(1003, "3 lbs", 7.99),
            new Item(1004, "5 lbs", 12.99),
            new Item(1005, "4 lbs", 9.49)
        };

        // Linear Search (Price)
        System.out.print("Enter a price to search: ");
        double price = scanner.nextDouble();

        if (linearSearch(items, price)) {
            System.out.println("Item with that price FOUND.");
        } else {
            System.out.println("Item with that price NOT found.");
        }

        // Binary Search (UPC)
        System.out.print("Enter a UPC to search: ");
        int upc = scanner.nextInt();

        if (binarySearch(items, upc)) {
            System.out.println("Item with that UPC FOUND.");
        } else {
            System.out.println("Item with that UPC NOT found.");
        }

        scanner.close();
    }
}