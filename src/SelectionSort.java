import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter in an integer value: ");
            arr.add(input.nextInt());
        }
        System.out.println(arr);
    }

    public static ArrayList<Integer> sortArrayList(ArrayList<Integer> arr) {
        boolean sorted = false;
        int loopCount = 0;
        while (!sorted) {
            sorted = true;
            for (int e = 0; e < arr.size(); e++) {

            }
        }

        return arr;
    }
}