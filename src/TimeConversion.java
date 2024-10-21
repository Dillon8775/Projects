import java.util.Scanner;

public class TimeConversion {
    private int userTime; // Our user time that is inputted
    private final int[] time = new int[2]; // Create an integer array list with a size of 2.
    private static final boolean classNotes = false; // Run class notes

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        if (classNotes) {
            Integer integerWrapper = new Integer(42);
            System.out.println(integerWrapper);

            pracMath();
            magPie(input);

            System.out.println("Exiting class notes, starting TimeConversion");
        }
        String test = "11";

        System.out.println("Welcome to the Time Conversion App!"); // Greet the user to the TimeConversion app.
        System.out.print("Please enter the time in minutes:\n>>>"); // Prompt the user to enter the current time (or whatever time they want) in minutes

        TimeConversion timeConversion = new TimeConversion(); // Create a new TimeConversion object
        timeConversion.setUserTime(input.nextInt()); // Set the user time to the users inputted time.

        timeConversion.convertTime(); // Convert the time (in minutes) to the actual time (in military time)

        System.out.println("Awesome! The time is currently: " + timeConversion.getHours() + ":" + timeConversion.getMinutes()); // Print out the time to the user.

        System.out.println("Let's calculate the duration of an event!"); // Move into the next phase of the TimeConversion app, calculating the end time of the event.
        System.out.print("Enter the hours of the start time for the event (in military format, 0-23):\n>>>"); // Prompts the user to enter the start time HOURS of the event (from 0-23).
        int startHour = input.nextInt();

        System.out.print("Enter the minutes of the start time for the event (0-59):\n>>>"); // Prompts the user to enter the start time MINUTES of the event (0-59).
        int startMinute = input.nextInt();

        System.out.print("Enter the duration of the event (in minutes)\n>>>"); // Prompts the user to enter the duration of the event (in minutes).
        int duration = input.nextInt();

        timeConversion.calculateEndTime(startHour, startMinute, duration);  // Calculate the end time of the event (see method for explanation).
    }

    // Set the private field user time.
    private void setUserTime(int userTime) {
        this.userTime = userTime;
    }

    // Get the hours of the time (index 0 in time)
    private int getHours() {
        return this.time[0];
    }

    // Get the hours of the time (index 1 in time)
    private int getMinutes() {
        return this.time[1];
    }

    // Convert the time.
    // Takes index 0 of time (hours) and divides by 60 to get the correct hour.
    // Takes index 1 of time (minutes) and MODs 60 to get the correct minute.
    private void convertTime() {
        this.time[0] = this.userTime / 60;
        this.time[1] = this.userTime % 60;
    }

    // Calculates the end time of an event.
    private void calculateEndTime(int startHour, int startMinute, int durationMinutes) {
        // The total minutes of the event (start hour times 60, plus start minute and duration minutes).
        int totalMinutes = startHour * 60 + startMinute + durationMinutes;

        // Gets the end hour of the event (total minutes divided by 60 and then mod 24, for the correct time format).
        int endHour = (totalMinutes / 60) % 24;
        // Gets the end minutes of the event (total minutes mod 60).
        int endMinute = totalMinutes % 60;

        // Print out the end time for the event, using a formatted string, for the hours, the colon, the minutes, and then a new line.
        System.out.printf("End time for event: %d:%02d\n", endHour, endMinute);
    }

    private static void pracMath() throws InterruptedException {
        System.out.println("Largest value I can represent with a Double:");
        System.out.printf("%,.2f%n", Math.pow(2, 31));
        Thread.sleep(1000);
        System.out.print("Largest value I can represent with a Double: ");
        System.out.printf("%s,2f%n", Math.pow(2, 63));
        Thread.sleep(1000);
        System.out.print("Test random range in inclusive of 25-60");
        System.out.println((int)(Math.random() * 36) + 25);
    }

    private static void magPie(Scanner in) {
        System.out.printf("%s%n%s", "Enter any message:\n>>>");
        String text = in.nextLine();
        while (text.length() != 0) {
            if (text.length() != 1) {
                System.out.println(text);
            } else {
                System.out.println("You have to enter something, dummy!: ");
            }
            System.out.printf("%s%n%s", "Enter another message:");
            text = in.nextLine();
        }
    }
}