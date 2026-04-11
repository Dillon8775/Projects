package college.abstracttraffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that an unhandicapped user marked in a handicapped spot. Charge of $100. Includes the print statement.
public class HandicappedTicket extends AbstractTicket {

    public HandicappedTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 100);
    }

    @Override
    public void printTicket() {
        System.out.println("TYPE: Handicapped | TAG: " + getTag() + " | VEHICLE: " +
                getColor() + " " + getMake() + " " + getModel() + " | FINE: $" + this.getCharge());
    }
}