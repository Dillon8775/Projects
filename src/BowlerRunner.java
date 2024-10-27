// There is not a global scope in Java.
// Pseudo global characteristics in static variable.
public class BowlerRunner {

    // Main method for Bowler app.
    public static void main(String[] args) throws InterruptedException {
        Bowler b1 = new Bowler(10);
        b1.update(1, 2, 9);
        int average = b1.getAverage();
        System.out.println("The average variable is local in scope to the main method: "+average);
    }
}