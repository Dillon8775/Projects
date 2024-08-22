import java.util.Scanner;

public class TicksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ticks to seconds (1), or seconds to ticks? (2)");
        int solveFor = scanner.nextInt();
        boolean ticksToSeconds = solveFor == 1;
        boolean secondsToTicks = solveFor == 2;
        double input;
        double answer;
        if (ticksToSeconds) {
            System.out.print("How many ticks?");
            input = scanner.nextInt();
            answer = input / 20;
            String ticks = input == 1 ? " tick" : " ticks";
            String seconds = answer == 1 ? " second." : " seconds.";
            System.out.print(input + ticks +" to equivalent to " + answer + seconds);
        } else if (secondsToTicks) {
            System.out.println("How many seconds?");
            input = scanner.nextInt();
            answer = input * 20;
            String seconds = input == 1 ? " second" : " seconds";
            System.out.print(input + seconds + " is equivalent to " + answer + " ticks.");
        } else {
            System.out.print("You didn't choose a valid option. Closing.");
        }
        scanner.close();
    }
}