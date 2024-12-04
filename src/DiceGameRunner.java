public class DiceGameRunner {

    public static void main(String[] args) {
        // Create one instance of roll
        DiceGame game1 = new DiceGame((int)(Math.random()*6)+1);
        // Test access to static variables (private/public)
        System.out.println("Game count:"+game1.game_count);
        // Seems to be accessible through object or class reference if public
        // Need a class method to obtain access to private static outside of class
        // Update roll value
        game1.setRoll((int)(Math.random()*6)+1);
        // Output roll value
        System.out.println(game1.getRoll());
        game1.checkWin();
    }
}