package college.rescursion;

import java.util.Scanner;

// Dillon Strickland
// 4/10/2026
// A recursive call example, where a method is called until something is true.
public class RecursionProgram {

    // Recursive call.
    public static void loadPallet(int boxes) {
        if (boxes < 4) {
            System.out.println("There are not enough to make another full pallet.");
            return;
        }

        System.out.println("Pallet Loaded");
        loadPallet(boxes - 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of boxes: ");
        int boxes = scanner.nextInt();

        loadPallet(boxes);

        scanner.close();
    }
}