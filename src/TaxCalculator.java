import java.util.Scanner;

/**
 * The main class file for the tax calculator.
 */
public class TaxCalculator {
    private String filingStatus; // The filling status for our tax
    private double taxableIncome; // The taxable income

    // The default constructor for our Tax Calculator
    public TaxCalculator(String filingStatus, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.taxableIncome = taxableIncome;
    }

    // The main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a new scanner object to take in user input
        System.out.print("Enter your filing status (MARRIED = M / SINGLE = S):\n>>>");
        String filingStatus = input.nextLine(); // Create and assign a local filingStatus variable to the users next input.
        filingStatus = filingStatus.toLowerCase(); // Turn all letters of the users inputted filing status to lowercase, for more accurate code

        // Assign proper filing status according the users input
        if (filingStatus.equals("m")) {
            filingStatus = "married";
        } else if (filingStatus.equals("s")) {
            filingStatus = "single";
        }

        System.out.println("Your filing status: " + filingStatus);

        System.out.print("Enter your taxable income: $\n>>>"); // Prompt the user to enter their taxable income
        double taxableIncome = input.nextDouble(); // Create and assign a local taxableIncome variable to the users next input (as a double).

        TaxCalculator taxCalculator = new TaxCalculator(filingStatus, taxableIncome); // Create a new TaxCalculator object.
        double taxLiability = taxCalculator.calculateTax(); // Create a local variable for taxLiability and make it the calculated tax that will be due.

        System.out.printf("Filing status: %s\n", filingStatus); // Print out the filing status
        System.out.printf("Taxable income: $%,.2f\n", taxableIncome); // Print out taxable income
        System.out.printf("Total tax liability: $%,.2f\n", taxLiability); // Print out the total tax liability due

        input.close(); // Close the scanner object to prevent memory leaks
    }

    // The method for calculating the base tax (if married, calculate married tax, if single calculate single tax)
    private double calculateTax() {
        return filingStatus.startsWith("married") ? calculateMarriedTax() : calculateSingleTax();
    }

    // The method for calculating the SINGLE tax.
    private double calculateSingleTax() {
        double tax = 0.0;
        if (taxableIncome <= 11000) {
            tax = 0.10 * taxableIncome;
        } else if (taxableIncome <= 44725) {
            tax = 1100 + 0.12 * (taxableIncome - 11000);
        } else if (taxableIncome <= 95375) {
            tax = 5147 + 0.22 * (tax - 44725);
        } else if (taxableIncome <= 182100) {
            tax = 16290 + 0.24 * (taxableIncome - 95375);
        } else if (taxableIncome <= 231250) {
            tax = 37104 + 0.32 * (taxableIncome - 182100);
        } else if (taxableIncome <= 578125) {
            tax = 52832 + 0.35 * (taxableIncome - 231250);
        } else {
            tax = 174238.25 + 0.37 * (taxableIncome - 578125);
        }
        return tax;
    }

    // The method for calculating the MARRIED tax.
    private double calculateMarriedTax() {
        double tax;
        if (taxableIncome <= 22000) {
            tax = 0.10 * taxableIncome;
        } else if (taxableIncome <= 89450) {
            tax = 2200 + 0.12 * (taxableIncome - 22000);
        } else if (taxableIncome <= 190750) {
            tax = 10294 + 0.22 * (taxableIncome - 89450);
        } else if (taxableIncome <= 364200) {
            tax = 32580 + 0.24 * (taxableIncome - 190750);
        } else if (taxableIncome <= 462500) {
            tax = 74080 + 0.32 * (taxableIncome - 364200);
        } else if (taxableIncome <= 693750) {
            tax = 105664 + 0.35 * (taxableIncome - 462500);
        } else {
            tax = 186601.50 + 0.37 * (taxableIncome - 693750);
        }
        return tax;
    }
}