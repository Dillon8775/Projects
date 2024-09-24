import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaCost {

    public static void main(String[] args) {
        // Grant the user to the Pizza Cost app.
        System.out.println("Welcome to the Pizza Cost app!");

        // Ask the user how many pizzas that they want to order.
        // Each pizza # will have their own respective diameter value.
        // To do this, we will use a Map, to hold a pizza number with its own unique diameter value.
        System.out.println("Let's calculate the cost of your pizza.");
        System.out.print("How many pizzas do you want?\n>>>");

        // Create a scanner object to collect the users input.
        Scanner input = new Scanner(System.in);
        // The amount of pizzas is equal to the number that the user inputs here.
        int amountOfPizzas = input.nextInt();

        // Here is our Map. This map will hold a diameter value for each pizza.
        // A Map is basically a way to hold key values for certain things.
        Map<Integer, Double> pizzaDiameters = new HashMap<>();

        // Create a variable called I and assign it to 1.
        // We do this because we can't have a pizza # of 0, that is nonsense.
        int i = 1;
        // Here is our diameter value. This value will be changed for each pizza,
        // and that current value will be put into our Map object.
        double diameter;
        // Create our final cost variable. Set it to 0 to start.
        double finalCost = 0;
        // While I is less than the amount of pizzas + 1 (we add +1 in the boolean because I starts at 1, not 0),
        // We ask the user what they want the diameter of the current pizza number to be.
        // Each pizza number will get their own diameter value, and stored in the Map object.
        while (i < (amountOfPizzas + 1)) {
            System.out.print("What do you want the diameter of pizza #"+i+" to be?\n>>>");
            // The diameter equals whatever the user types into the console.
            diameter = input.nextDouble();

            // Put our diameter value into our Map, assigning it to the pizza number.
            // Ex. put pizza number 1 with a diameter of 10, pizza number 2 with a diameter of 15, pizza number 3 with a diameter of 23, etc.
            pizzaDiameters.put(i, diameter);

            // Increase the cost by 1.75 ($1.00 for rent, $0.75 for labor) for each pizza.
            finalCost += 1.75;

            // Increment I by one to jump to the next pizza number.
            // If I meets the pizza number that the user inputted, this loop breaks.
            i++;
        }

        // For each diameter value in our Map object,
        // we need to add it to the final cost.
        // However, the diameter cost is actually 0.05 * diameter * diameter.
        // So, we assign the current diameter value being used in the loop, to itself twice, times 0.05.
        // Then, we add that value to the final cost.
        for (double diameterValue : pizzaDiameters.values()) {
            diameterValue = calculateDiameter(diameterValue);
            finalCost += diameterValue;
        }

        // Print the final cost of the users' order for all pizzas combined.
        System.out.println("Awesome! The final cost of your pizza is $" + finalCost + ".");
        // Farewell to the user.
        System.out.println("Have a great day!");
    }

    // Here is how we calculate our actual diameter value.
    // We need to multiply the diameter value by itself, twice, then multiply it by 0.05.
    // After all of this, we return this value.
    private static double calculateDiameter(double diameter) {
        return 0.05 * diameter * diameter;
    }
}