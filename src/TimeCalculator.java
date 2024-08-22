import java.util.Scanner;

public class TimeCalculator {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHOOSE FROM:");
        System.out.println("Seconds To Minutes (1) | Minutes To Seconds (2) | Minutes To Hours (3) | Hours To Days (4) | Weeks To Days (5)");
        int answer = scanner.nextInt();
        boolean secondsToMinutes = answer == 1;
        boolean minutesToSeconds = answer == 2;
        boolean minutesToHours = answer == 3;
        boolean hoursToDays = answer == 4;
        boolean weeksToDays = answer == 5;

        if (secondsToMinutes) {
            System.out.println("How many seconds?");
            double seconds = scanner.nextInt();
            double minutes = seconds / 60;
            String secondString = seconds == 1 ? " second" : " seconds";
            String minuteString = minutes == 1 ? " minute." : " minutes.";
            System.out.println(seconds + secondString + " is equivalent to " + minutes + minuteString);
        } else if (minutesToSeconds) {
            System.out.println("How many minutes?");
            double minutes = scanner.nextDouble();
            double seconds = minutes * 60;
            String minuteString = minutes == 1 ? " minute" : " minutes";
            String secondString = seconds == 1 ? " second." : " seconds.";
            System.out.println(minutes + minuteString + " is equivalent to " + seconds + secondString);
        } else if (minutesToHours) {
            System.out.println("How many minutes?");
            double minutes = scanner.nextDouble();
            double hours = minutes / 60;
            String minuteString = minutes == 1 ? " minute" : " minutes";
            String hourString = hours == 1 ? " hour." : " hours.";
            System.out.println(minutes + minuteString + " is equivalent to " + hours + hourString);
        } else if (hoursToDays) {
            System.out.println("How many hours?");
            double hours = scanner.nextDouble();
            double days = hours / 24;
            String hourString = hours == 1 ? " hour" : " hours";
            String dayString = days == 1 ? " day." : " days.";
            System.out.println(hours + hourString + " is equivalent to " + days + dayString);
        } else if (weeksToDays) {
            System.out.println("How many weeks?");
            double weeks = scanner.nextInt();
            double days = weeks * 7;
            String weekString = weeks == 1 ? " week" : " weeks";
            String dayString = days == 1 ? " day" : " days";
            System.out.println(weeks + weekString + " is equivalent to approximately " + "~" + days + dayString + " (depending on the month).");
        }
        scanner.close();
    }
}