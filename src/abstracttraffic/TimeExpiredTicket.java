package abstracttraffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that the car was parked too long. Charge of $50. Includes the print statement.
public class TimeExpiredTicket extends AbstractTicket {

    public TimeExpiredTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 50);
    }

    @Override
    public void printTicket() {
        System.out.println("TYPE: Expired Meter | TAG: " + getTag() + " | VEHICLE: " +
                getColor() + " " + getMake() + " " + getModel() + " | FINE: $" + this.getCharge());
    }
}