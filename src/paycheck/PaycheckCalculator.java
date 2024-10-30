package paycheck;

import util.IMath;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class PaycheckCalculator {

    public void run() {
        while (true) {
            try {
                calculate();
                break;
            } catch (InputMismatchException o) {
                System.out.println("Please input a valid number.");
                System.out.println();
            }
        }
    }

    public void calculate() {
        System.out.print("How much do you make per hour?\n>>>");
        Scanner scanner = new Scanner(System.in);
        double hourlyPay = scanner.nextDouble();

        System.out.print("How many hours did you work this week?\n>>>");
        double hoursWorked = scanner.nextDouble();

        double grossIncome = hoursWorked * hourlyPay;

        double federalIncomeTax = grossIncome * IMath.toDecimal(this.federalIncomeTaxPercentage());
        double socialSecurityTax = grossIncome * IMath.toDecimal(this.socialSecurityTaxPercentage());
        double medicareTax = grossIncome * IMath.toDecimal(this.medicareTaxPercentage());
        double stateIncomeTax = grossIncome * IMath.toDecimal(this.stateIncomeTaxPercentage());

        double totalDeductions = federalIncomeTax + socialSecurityTax + medicareTax + stateIncomeTax;

        double netIncome = grossIncome - totalDeductions;

        grossIncome = IMath.round(grossIncome, false);
        federalIncomeTax = IMath.round(federalIncomeTax, false);
        socialSecurityTax = IMath.round(socialSecurityTax, false);
        medicareTax = IMath.round(medicareTax, false);
        stateIncomeTax = IMath.round(stateIncomeTax, false);
        totalDeductions = IMath.round(totalDeductions, false);
        netIncome = IMath.round(netIncome, false);

        System.out.println("Gross Income: $" + grossIncome);
        System.out.println();

        System.out.println("Federal Income Tax (" + this.federalIncomeTaxPercentage() + "%): $" + federalIncomeTax);
        System.out.println("Social Security Tax (" + this.socialSecurityTaxPercentage() + "%): $" + socialSecurityTax);
        System.out.println("Medicare Tax (" + this.medicareTaxPercentage() + "%): $" + medicareTax);
        System.out.println("State Income Tax (" + this.stateIncomeTaxPercentage() + "%): $" + stateIncomeTax);
        System.out.println();

        System.out.println("Total Deductions: $" + totalDeductions);
        System.out.println("Net Income: $" + netIncome);
    }

    public abstract double federalIncomeTaxPercentage();

    public abstract double socialSecurityTaxPercentage();

    public abstract double medicareTaxPercentage();

    public abstract double stateIncomeTaxPercentage();
}