package paycheck;

public class NCCalculator extends PaycheckCalculator {

    public static void main(String[] args) {
        NCCalculator ncCalculator = new NCCalculator();
        ncCalculator.run();
    }

    @Override
    public double federalIncomeTaxPercentage() {
        return 0.64;
    }

    @Override
    public double socialSecurityTaxPercentage() {
        return 6.20;
    }

    @Override
    public double medicareTaxPercentage() {
        return 1.45;
    }

    @Override
    public double stateIncomeTaxPercentage() {
        return 1.00;
    }
}