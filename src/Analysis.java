import java.util.ArrayList;

public class Analysis {
    private int[] numbers; // store input numbers
    private int count; // track number of elements entered by user

    // Constructor
    public Analysis(int size) {
        numbers = new int[size]; // create a list of numbers with correct size
        count = 0;
    }

    public void runClassNotes() {
        // 8.1
        // An ArrayList object is mutable and contains object references.

        // Arrays are static in size, once initialized, their size cannot be changed.
        // ArrayLists are dynamic in size, the size of the list can be changed at any time.

        // 8.2
        // In order to use prewritten ArrayList class, you must import it from the java.util package using the following Java code:
        // import java.util.ArrayList;
        // or
        // import java.util.List;

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        // arraylist a1 has been instantiated with no entries.
        System.out.println(a1.size());

        // boolean add (E obj) : Appends obj to the end of list; returns true.
        // void add (int index, E obj) : inserts obj at position index (0 <= index <= size), moving elements at position index and higher to the right (adds 1 to their indices) and adds 1 to list size.

        // a1.remove(3); // Removes index 3 from arraylist
        // a1.set(3, 5); // Replaces the element at position index with obj; returns the element
        // getting items from an array list: a1.get(4); - gets element at position 4

        ArrayList<String> a2 = new ArrayList<String>(5);
        ArrayList<Object> a3 = new ArrayList<Object>();

        int sum = 0;
        for (int i = 0; i <= a2.size() - 1; i++) {
            sum = sum + a2.get(i).length();
        }
        System.out.println(sum);

        int sum1 = 0;
        int j = 0;
        while (j < a2.size()) {
            sum = sum + a2.get(j).length();
            j++;
        }
        System.out.println(sum1);

        for (int g = a1.size() - 1; g >= 0; g--) {
            if (a1.get(g) < 70.0) {
                a1.remove(g);
            }
        }
    }

    // find sum method
//    private int findSum(ArrayList<Integer> values) {
//        int total = 0;
//        for (int i = 0; i < values.size(); i++) {
//            total = total + values.get(i);
//        }
//        return total;
//    }

    // find word method
//    public int findTheWord(String searchedPhrase, ArrayList<Book> myBooks) {
//        for (int index = 0; index < myBooks.size(); index++) {
//            Book currentBook = myBooks.get(index);
//            String currentPhrase = currentBook.getDescription();
//            if (currentPhrase.equals(searchedPhrase)) {
//                return index;
//            }
//        }
//        return -1;
//    }

    // Method to add numbers
    public void addNumber(int num) {
        // Incorrect implementation: did not check if count exceeds the array size
        // numbers[count++] = num; // This may cause an ArrayIndexOutOfBoundsException

        if (num >= 1 && num <= 50 && count < numbers.length) {
            numbers[count] = num;
            count++;
        } else {
            // Debugging log
            System.out.println("Error: Number out of range or array is full.");
        }
    }

    // Calculate average
    public double getAverage() {
        if (count == 0) {
            return 0; // Prevent division by zero
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += numbers[i];
        }
        return (double) sum / count;
    }

    // Find maximum value
    public int getMax() {
        if (count == 0) return 0;

        // Incorrect: Starting max from 0 may cause incorrect results if all numbers are negative
        // int max = 0;

        int max = numbers[0];
        for (int i = 1; i < count; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // Find minimum value
    public int getMin() {
        if (count == 0) {
            return 0;
        }

        // Incorrect: Not initializing min to the first element might result in wrong comparisons
        // int min = 50;

        int min = numbers[0];
        for (int i = 1; i < count; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    // Calculate range (max - min)
    public int getRange() {
        if (count == 0) {
            return 0;
        }
        return getMax() - getMin();
    }

    // Find the most frequently occurring number (mode)
    public int getMedianMode() {
        if (count == 0) return 0;
        int mode = numbers[0], maxCount = 0;

        // Incorrect: Forgot to track maxCount for frequency calculations
        // int mode = 0;

        for (int i = 0; i < count; i++) {
            int num = numbers[i];
            int numCount = 0;
            for (int j = 0; j < count; j++) {
                if (numbers[j] == num) {
                    numCount++;
                }
            }
            if (numCount > maxCount) {
                maxCount = numCount;
                mode = num;
            }
        }
        return mode;
    }

    // Generate and display histogram
    public void displayHistogram() {
        System.out.println("\nHistogram:");
        for (int i = 1; i <= 50; i += 5) {
            int upperBound = i + 4;
            int countInRange = 0;
            for (int j = 0; j < count; j++) {
                if (numbers[j] >= i && numbers[j] <= upperBound) {
                    countInRange++;
                }
            }
            System.out.print(i + " - " + upperBound + " : ");
            for (int k = 0; k < countInRange; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Override toString to display results
    @Override
    public String toString() {
        return "Average: " + getAverage() + "\n" +
                "Max: " + getMax() + "\n" +
                "Min: " + getMin() + "\n" +
                "Range: " + getRange() + "\n" +
                "Mode: " + getMedianMode();
    }

    // Test method
//    public static void test() {
//        Analysis testAnalysis = new Analysis(10);
//        testAnalysis.addNumber(5);
//        testAnalysis.addNumber(15);
//        testAnalysis.addNumber(25);
//        testAnalysis.addNumber(35);
//        testAnalysis.addNumber(45);
//        testAnalysis.addNumber(5);
//        testAnalysis.addNumber(15);
//        testAnalysis.addNumber(25);
//        testAnalysis.addNumber(35);
//        testAnalysis.addNumber(45);
//
//        System.out.println("\nTest Results:");
//        System.out.println(testAnalysis);
//        testAnalysis.displayHistogram();
//    }
}