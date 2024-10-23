import java.util.Scanner;

public class Investment {
    private static final boolean classNotes = false; // Run class notes
    private double initialInvestment, targetAmount, annualInterestRate; // Our initial investment, target amount, and annual interest rate variables (doubles)

    // Our Investment class constructor. This initializes all of our variables, so that they have the correct values when the user inputs them into the console when the program runs.
    public Investment(double initialInvestment, double targetAmount, double annualInterestRate) {
        this.initialInvestment = initialInvestment;
        this.targetAmount = targetAmount;
        this.annualInterestRate = annualInterestRate;
    }

    // Method to calculate years and the exact month it will take to reach the target amount
    public String calculateYearsAndMonth() {
        double amount = initialInvestment;
        int years = 0;
        int months = 0;
        String[] monthsOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // Calculate years until the investment surpasses or reaches the target
        while (amount < targetAmount) {
            amount += amount * (annualInterestRate / 100);
            years++;
        }

        // Backtrack one year and calculate month-by-month for the final year
        amount = initialInvestment;
        for (int i = 0; i < years - 1; i++) {
            amount += amount * (annualInterestRate / 100);  // Add interest for each complete year
        }

        // Calculate the months in the FINAL year until the target is reached
        while (amount < targetAmount) {
            amount += amount * (annualInterestRate / 100 / 12);  // Add annual interest rate, month by month
            months++;
        }

        // Print result!
        return "It will take " + years + " years and reach the target in " + monthsOfYear[months - 1] + ".";
    }

    // Allows the investment object to be correctly printed as a string.
    @Override
    public String toString() {
        return "Initial investment: $"+initialInvestment+
                "\nTarget Amount: $"+targetAmount+
                "\nAnnual Interest Rate: "+(annualInterestRate * 100)+"%"+ calculateYearsAndMonth();
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

//        if (classNotes) {
//            // VIDEO 1 (10/21/2024)
//            int number = 5;
//
//            while (/* BOOLEAN EXPRESSION */ number > 50) { // <- while this boolean expression is TRUE, the code in the block will run repeatedly, or in a loop.
//                // statement one
//                // statement two
//                // other code to repeat...
//
//                // update loop control variable (or boolean expression)
//
//                // we can also use the "break" statement to exit the loop, regardless of the state of the boolean expression.
//            }
//
//            while (number < 100) {
//                System.out.print(number + " ");
//                number += 5;
//            }
//
//            System.out.println();
//
//            int count = 2;
//            while (count <= 100) {
//                System.out.print(count + " ");
//                count *= 2;
//            }
//
//            int number2 = 20;
//            while (number2 >= 0) {
//                System.out.print(number2 + " ");
//                number2 -= 1;
//            }
//
//            System.out.println();
//
//            // VIDEO 2 (10/21/2024)
//
////            This code will run forever. Never ending. Until the process is killed.
////            With something like this, any code after this while statement cannot run, because "true" always evaluates to true, it cannot be false, therefor nothing else can run.
////            while (true) {
////                System.out.print("AP CSA ");
////            }
//
//            int value = 10; // Initialize value to 10
//            while (value >= 0) { // While value is greater than 0, run the code in this block.
//                System.out.print(value); // Print the current value of "value"
//                value--; // Subtract value by one at the end of the statement, then go through the loop again (unless value is not greater than or equal to 0)
//            }
//
//            int number3 = 5; // Initialize value to 5
//            while (number3 <= 100) { // While number3 is greater than or equal to 100, run the code in this block.
//                System.out.print(number3 + " "); // Print the current value of number3, with a space at the end.
//                number3 += 5; // Increment number3 by five, exit the statement, and go again.
//            }
//
//            System.out.println();
//
//            boolean sentinel = true;
//            while (sentinel) {
//                // do something
//                System.out.println("Enter a message, OR, type \"end\" or \"continue\" to proceed to the next code: ");
//                String msg = input.nextLine();
//                if (!(msg.equals("end") || msg.equals("continue"))) {
//                    System.out.println(msg);
//                } else {
//                    break;
//                    // OR, "sentinel = false". In this case, using the break statement would be a better approach.
//                }
//            }
//
//            // VIDEO 1 (10/22/2024)
//            // IMPORTANT NOTE:
//            // % 10 returns the LAST DIGIT of a number.
//            // / returns every digit in a number EXCEPT the last number
//
//            int fiveThousand = 5384;
//            int sum = 0;
//
//            while (fiveThousand > 0) {
//                int lastDigit = fiveThousand % 10;
//                sum += lastDigit;
//                fiveThousand = fiveThousand / 10;
//            }
//
//            System.out.println("The sum of " + fiveThousand + " = " + sum);
//
//            double balance = 200.0;
//            double intRate = 10.0;
//            int years = 0;
//            // compounding interest logic
//
//            while (balance <= 1000) {
//                balance += balance * (intRate / 100);
//                years += 1;
//                System.out.println("Year: "+years+"\nBalance: $"+balance);
//                /* Thread.sleep(1000); */
//            }
//
//            System.out.println("I will reach my goal in "+years+" years.");
//
//            // FOR LOOPS (10-23-2024)
//            // PARTS OF FOR LOOPS -> initialization; boolean expression; update (typically increment/decrement)
//            // ENTER FOR LOOP BY INITIALIZING VARIABLE
//            // CHECK BOOLEAN EXPRESSION - IF FALSE, EXIT THE LOOP. IF TRUE, REPEAT UNTIL FALSE.
//
//            for (/*VARIABLE INITIALIZATION*/ int num = 1; /*BOOLEAN EXPRESSION*/ num <= 5;/*UPDATE LOOP CONTROL VARIABLE*/ num++) {
//                System.out.println(num);
//            }
//            System.out.println("Finished first for loop!");
//
//            for (int x = 2; x <= 20; x += 3) {
//                System.out.print(x+" ");
//            }
//            System.out.println();
//
//            int total = 0;
//            for (int i = 1; i <= 10; i++) {
//                total += i;
//            }
//            System.out.println(total);
//
//            // COMPARING WHILE AND FOR LOOPS
//
//            // WHILE LOOPS ARE HARDER TO READ, BUT ITS CODER PREFERENCE. THEY CAN DO THE SAME THING.
//            int whileNum = 1;
//            while (whileNum <= 5) {
//                System.out.println(whileNum);
//                whileNum++;
//            }
//            System.out.println("Finished while loop! (comparing while and for loops)");
//
//            // FOR LOOPS ARE MORE COMPACT AND EASIER TO READ
//            // for loops are generally optimized to iterate through sequence-like objects
//            for (int i = 1; i <= 5; i++) {
//                System.out.println(i);
//            }
//            System.out.println("Finished for loop! (comparing while and for loops)");
//
//            // This is also a "do" loop. What this does, the code in the "do" block executes ONE TIME FIRST, and THEN, checks the while loop boolean, and repeats until the boolean expression is false.
//            // But, regardless of the boolean condition, the code inside the "do" block will execute one time, before ever checking the condition of boolean expression.
//            int doNum = 5;
//            do {
//                System.out.println(doNum);
//                doNum--;
//            } while (doNum >= 4);
//            System.out.println("Finished do-while loop.");
//
//            System.out.print("Enter a message:\n>>>");
//            String message = input.nextLine();
//            for (int i = 0; i < message.length(); i++) {
//                // will print each character in message
//                System.out.println(message.charAt(i));
//            }
//        }
//
//        System.out.println("======");

        // BEGINNING OF INVESTMENT CODE

        // Just let the user know that the Investment program is now beginning to run.
        System.out.println("Running \"Investment\" class...");

        // Prompts the user to enter their initial investment amount.
        System.out.println("Enter your investment amount: ");
        double initialInvestment = input.nextDouble(); // Declare an initial investment variable, and set it to whatever the user inputs next (as a double)

        // Prompts the user to enter their target amount that the initial investment will be worth.
        System.out.println("Enter the target amount to be worth: ");
        double targetAmount = input.nextDouble();

        // Prompts the user to enter the annual interest rate as a PERCENTAGE. This value will later be converted to a decimal.
        System.out.println("Enter the annual interest rate (as a PERCENTAGE): ");
        double annualInterestRate = input.nextDouble();
        annualInterestRate /= 100; // Convert annual interest rate percentage to a decimal.

        // Create a new Investment object, passing in our previously declared variables.
        Investment investment = new Investment(initialInvestment, targetAmount, annualInterestRate);

        // Print out the investment (as a string, see toString method above)
        System.out.println(investment);

        while (true) {
            System.out.println("Enter a new annual interest rate (or type 0 to exit the program): ");
            double newRate = input.nextDouble();
            if (newRate == 0) {
                break;
            }
            investment.annualInterestRate = newRate;
            System.out.println(investment);
        }
    }
}