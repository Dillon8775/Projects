import java.util.Scanner;

public class OrderApp {
    // Our primitive data types.
    private int burgers;
    private int fries;
    private int sodas;

    /**
     * Our constructor for the OrderApp.
     */
    public OrderApp(int burgers, int fries, int sodas) {
        this.burgers = burgers;
        this.fries = fries;
        this.sodas = sodas;
    }

    /**
     * Returns the total amount of burgers inputted by the user (see main method)
     */
    public int getBurgers() {
        return this.burgers;
    }

    /**
     * Returns the total amount of fries inputted by the user (see main method)
     */
    public int getFries() {
        return this.fries;
    }

    /**
     * Returns the total amount of sodas inputted by the user (see main method)
     */
    public int getSodas() {
        return this.sodas;
    }

    /**
     * Adds three digits together.
     */
    private static double addAll(double x, double y, double z) {
        return x + y + z;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the order application!"); // Welcome the user
        System.out.print("How many burgers would you like to order?\nBurgers are $1.69 each.\n>>>"); // Prompt the user for amount of burgers

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // Create a local variable, storing the users inputted amount for amount of burgers

        System.out.print("Great! Now, how many fries would you like to order?\nFries are $1.09 per box.\n>>>"); // Prompt the user for the amount of fries
        int y = scanner.nextInt(); // Create another local variable, storing the users inputted amount for amount of fries

        System.out.print("Awesome! Finally, how many sodas would you like to order.\nSodas are $0.99 per bottle.\n>>>"); // Prompt the user for the amount of sodas
        int z = scanner.nextInt(); // Create one final local variable, storing the users inputted amount for amount of sodas

        OrderApp orderApp = new OrderApp(x, y, z); // Create the order app object, with the users inputted amounts for each item

        double burgersPrice = orderApp.getBurgers() * 1.69; // Burgers price is the total amount of burgers times for it ($1.69 per burger)
        System.out.println("You purcashed "+orderApp.getBurgers()+" burgers, costing $"+burgersPrice+"."); // Tell the user their price for burgers alone
        double friesPrice = orderApp.getFries() * 1.09; // Fries price is the total amount of fries times the price for it ($1.09 per box)
        System.out.println("You purchased "+orderApp.getFries()+" fries, costing $"+friesPrice+"."); // Tell the user their price for fries alone
        double sodasPrice = orderApp.getSodas() * 0.99; // Sodas price is the total amount of soda bottles times the price for it ($0.99 per bottle)
        System.out.println("You purcashed "+orderApp.getSodas()+" sodas, costing $"+sodasPrice+".");

        double totalBeforeTax = addAll(burgersPrice, friesPrice, sodasPrice); // The final burger price, fries price, and soda prices combined
        System.out.println("Your total (before tax): $" + totalBeforeTax); // Tell the user their total (before tax.)

        double tax = totalBeforeTax * 0.065; // Takes the total (before tax) and add tax percentage to it (0.065 is 6.5% as a percentage)
        double finalTotal = totalBeforeTax + tax; // Takes the total (before tax) and add the tax amount to it
        System.out.println("Your final total (after tax): $" + finalTotal); // Tell the user their final total (after tax)

        System.out.print("Enter your payment amount:\n>>>"); // Prompt the user to pay
        double amount = scanner.nextDouble(); // Stores the users inputted amount

        double change = amount - finalTotal; // Gets the users change (the amount inputted minus the final total)
        System.out.println("Awesome! Here's your change: $" + change); // Print the users change and give it to them (not literally)
        
        System.out.println("Thanks for using the order app! See you again soon!"); // Farewell to the user
    }

    /*
     * CLASS NOTES:
     * Non-static method requires an instance of the Object in order to call that method.
     * Void means nothing returns.
     */
}