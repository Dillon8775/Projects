public class RandomStats {
    private static boolean classNotes = true;

    // The main method
    public static void main(String[] args) {
        if (classNotes) {
            runClassNotes();
        }

        // Create an array of a fixed size of 10 for the amount of occurrences for each number.
        int[] occurrences = new int[10];
        // Generate a random number 500 times.
        for (int i = 0; i < 500; i++) {
            int random = (int)(Math.random()*10);
            occurrences[random]++; // Add each number to its respective occurrence.
        }
        // Print the number of occurrences for each number.
        System.out.println("Number\tOccurrences");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t\t" + occurrences[i]);
        }
    }

    private static void runClassNotes() {
        // An array is a data structure used to implement a collection (list) of primitive or object reference data.
        // An element is a single value in the array.
        // The index of an element is the position of the element in the array.
        // In Java, the first element of an array is index 0.
        // The length of an array is the number of elements in an array.
        // length is a public final data member of an array.
        // Since length is public, we can access it any class.
        // Since length is final, we cannot change an array's length after it has been created
        // In Java, the last element of an array named list is at index list.length - 1.

        int[] listOne = new int[5];
        listOne[3] = listOne[2] * 3;
        listOne[4] = 13;

        // Elements of type int are initialized to 0 automatically.
        // Elements of a reference type are initialized to the reference value null.

        // Elements of type double are initialized 0.0 automatically.

        // Elements of type boolean are initialized to false automatically.

        double[] grades = {70.5, 88.2, 93.7, 98.7};

        double[] nums = {0, 10, 16};
        nums[1] += 4.5;
//        nums[3] = 95;
        System.out.println(nums[1]);

        /**
         * public class ArrayManipulator {
         *     private int[] list;
         *
         *     public ArrayManipulator(int numElements) {
         *         // part a
         *         // dont do this
         *         list[] = new int[numElements];
         *         // instead do this
         *         list = new int[numElements];
         *     }
         *
         *     public int getMiddleIndex() {
         *         //part b
         *         if (list.length % 2 == 0) {
         *            return (list[list.length / 2])-1;
         *         }
         *         return list[list.length / 2];
         *    }
         * }
         */
    }
}