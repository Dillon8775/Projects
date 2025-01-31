import java.util.Scanner;

public class AnalysisRunner {
    private static boolean classNotes = false; // enable to run class notes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Analysis analysis = new Analysis(20); // start with size 20, can be tested with bigger sizes

        System.out.println("Enter numbers between 1 and 50 (Enter -1 to stop):");
        while (true) {
            int input = scanner.nextInt();
            if (input == -1) { // if user enters -1, stop and display histogram
                break;
            }
            analysis.addNumber(input); // add number to list
        }

        // print results
        System.out.println("\nResults:");
        System.out.println(analysis);
        analysis.displayHistogram();

        if (classNotes) {
            analysis.runClassNotes();
        }

        // testing method
        // Analysis.test();

        // close the scanner to save memory
        scanner.close();
    }
}