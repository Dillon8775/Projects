import java.util.Scanner;

public class BankInterest {
    
    public static void main(String[] args) {
        
        // Declare our main primitive-type variables.
        double originalBal;
        double interestRate;
        int term;

        /* 
         * Declare a couple of booleans that will be used later on in the program to determine
         * how the final interest rate is calculated.
        */
        boolean yearlyRate;
        boolean yearlyTerm;

        // Create a scanner object to get the user's inputs.
        Scanner input = new Scanner(System.in);

        // Welcome the user to the program, and make sure that the programs use is easy to understand, and straight forward.
        System.out.println("Welcome to the Bank Interest Calculator!");
        System.out.println("Here, you can calculate your interest rate, annually or monthly.");
        System.out.print("To start, type in your original balance:\n>>>");
        originalBal = input.nextDouble(); // The original balance will equal whatever the user types into the console at this moment.

        String type; // Create a string variable to determine if the interest rate is yearly or monthly.
        System.out.print("Are you calculating your (Y) yearly rate, or (M) monthly rate?\n>>>");
        type = input.next(); // The "type" (Y = yearly, M = monthly) equals whatever the user types into the console at this moment.
        checkType(type, input);
        yearlyRate = type.equals("Y"); // Our yearly rate variable returns true if the interset rate type is equal to yearly (or Y).

        // Get our interest rate as a percentage.
        System.out.print("Alright, now, input your interest rate as a percentage.\n>>>");
        interestRate = input.nextDouble();

        // Get our term in yearly or monthly.
        System.out.print("Great! Now, let's do you term.\nIs your term in years (Y), or months (M)?\n>>>");
        type = input.next(); // Calling our "type" variable again, which determins if the term is yearly or monthly.
        checkType(type, input);
        yearlyTerm = type.equals("Y"); // Our yearly term variable returns true if the term type is equal to yearly (or Y).

        // Get our term amount as an integer.
        System.out.print("Awesome. Now, what's your term amount (as a number)?\n>>>");
        term = input.nextInt();

        double actualInterestRate = interestRate / 100; // Create a variable to convert the interest rate percentage to a decimal, for better calculation.
        double totalInterestRate = originalBal * actualInterestRate * term; // Create our final interest rate variable, which calculates the actual interest rate.

        /*
         * If the user does not input a yearly rate, but a yearly term, the totalInterestRate value will be multiplied by 12.
         * Otherwise, if the user did input a yearly rate, but a monthly term, then the totalInterestValue will be divided by 12.
         */
        if (!yearlyRate && yearlyTerm) {
            totalInterestRate *= 12;
        } else if (yearlyRate && !yearlyTerm) {
            totalInterestRate /= 12;
        }

        // Create a variable to get our end balance, which adds our original balance, and our total interest aret.
        double endBalance = originalBal + totalInterestRate;

        // Print out our final variables, which are our original balance, total interest rate, and end balance.
        System.out.println("Your original balance: $" + originalBal);
        System.out.println("Your interest earned: $" + totalInterestRate);
        System.out.println("Your end balance: $" + endBalance);

        // Close the Scanner object to save resources, and say goodbye to the user.
        input.close();
        System.out.println("Thanks for using the Bank Interest Calculator! :)");
    }

    
    /*
     * Determines if the "yearly" or "monthly" type for the interest rate, or term, is valid.
     * This returns true if the variable is equal to Y, or M.
     * If it does not equal this, then the user inputted something incorrectly, and will be prompted to try again.
     */
    private static boolean typeValid(String type) {
        return type.equals("Y") || type.equals("M");
    }

    /* If the user does not type in "Y" or "M", or rather something else, this code will repeat until the user inputs a valid answer.
     * Paramenter "type" is the "type" String declared in the main method.
     * Parameter "scanner" is the Scanner object declared in the main method.
    */
    private static void checkType(String type, Scanner scanner) {
        while (!typeValid(type)) {
            System.out.println("Hm, it seems you did not enter a valid answer. Please try again.");
            type = scanner.next();
        }
    }

    /* #5 Answer:
     * Java is extremely exact when it comes to data types because these are primitive data-types,
     * meaning that they are very precise and purely mathematical, and are exact.
     * You have to be very careful when dealing with integers, doubles and floats,
     * because one *slight* miscalculation can cause the entire program to result in a exception,
     * or possibly the numbers getting all mixed up, and not equaling or resulting in what you
     * expected them to. I was having this problem when trying to calculate the interest rate,
     * because I had a boolean expression in the wrong spot, and it ended up diving something by
     * 12, and messed up the final result.
    */
}