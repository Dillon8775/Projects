package arrays;

import java.util.Scanner;

// Dillon C. Strickland
// February 16th, 2025
// Calculates the commission rate for 10 employees, with their base pay multiplied by the commission rate, and then calculates the average salary for that period of time.
public class Commission {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants for the payment logic
        final int numberOfEmployees = 10;
        final double basePay = 500.00;
        final double commissionRate = 0.065; // 6.5%

        // Arrays to store our data
        double[] sales = new double[numberOfEmployees];
        double[] salaries = new double[numberOfEmployees];

        double totalSalarySum = 0;

        // 1. Input Loop: Gather sales and calculate salaries
        System.out.println("Enter the sales for " + numberOfEmployees + " employees:");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.print("Employee " + (i + 1) + " sales: $");
            sales[i] = input.nextDouble();

            // Calculate salary: 500 + (sales * 0.065)
            salaries[i] = basePay + (sales[i] * commissionRate);

            // Keep a running total for the average later
            totalSalarySum += salaries[i];
        }

        // 2. Output: Display the data in a clear format
        System.out.println("\n--- Weekly Pay Report ---");
        System.out.printf("%-15s %-15s %-15s%n", "Employee", "Sales", "Salary");

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee %-6d $%-14.2f $%-14.2f%n", (i + 1), sales[i], salaries[i]);
        }

        // 3. Average Calculation
        double averageSalary = totalSalarySum / numberOfEmployees;
        System.out.println("-------------------------");
        System.out.printf("Average Salary for the Period: $%.2f%n", averageSalary);

        input.close();
    }
}