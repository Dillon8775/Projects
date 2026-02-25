package accounts;

// Dillon Craig Strickland
// 2/25/2025
// A representation of a car loan, which implements the iMailable interface, to be easily printed out to the user.
public class CarLoan implements iMailable {
    private String name;
    private double owed;
    private double rate;
    private double monthlyPayment;

    public CarLoan(String name, double owed, double rate, double monthlyPayment) {
        this.name = name;
        this.owed = owed;
        this.rate = rate;
        this.monthlyPayment = monthlyPayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOwed() {
        return owed;
    }

    public void setOwed(double owed) {
        this.owed = owed;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void printStatement() {
        System.out.println("Name: " + name + ", Amount Owed: $" + owed + ", Rate: $" + rate + ", Monthly Payment: $" + monthlyPayment);
    }
}