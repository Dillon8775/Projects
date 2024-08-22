import java.util.Scanner;

public class MillisecondsToSeconds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many seconds?");
        int seconds = scanner.nextInt();
        int milliseconds = seconds * 1000;
        System.out.print(seconds + " seconds is equivalent to " + milliseconds + " milliseconds.");
        scanner.close();
    }
}