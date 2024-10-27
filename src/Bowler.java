public class Bowler {
    // Private variables, can only be accessed within this class scope.
    private int totalPins;
    private int games;

    // Constructor to initialize our private variables
    public Bowler(int pins) throws InterruptedException {
        totalPins = pins; // total pins equals passed in pins
        games = 3; // games = 3
        System.out.println("I am now in the class scope."); // Print to console when new Bowler instance is initialized.
        Thread.sleep(1000);
    }

    // Update the total pins and games after all 3 games.
    public void update(int game1, int game2, int game3) throws InterruptedException {
        // declaring variable as "private" throws an exception
        // cannot declare private or public in a local scope
        // int newPins = game1+game2+game3;
        System.out.printf("%d%d%d%n%s%n%s",game1,game2,game3,"These values are local in scope.","Going to sleep for a sec...\n");
        totalPins += (game1+game2+game3);
        games += 3;
        Thread.sleep(1000);
    }

    // Get the average of the game.
    public int getAverage() {
        return totalPins/games;
    }
}