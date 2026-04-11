package college.abstracttraffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that the user parked near a fire lane or beside a fire hydrant. Charge of $150. Includes the print statement.
public class FireLaneTicket extends AbstractTicket {

    public FireLaneTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 150);
    }

    @Override
    public void printTicket() {
        System.out.println("TYPE: Fire Lane | TAG: " + getTag() + " | VEHICLE: " +
                getColor() + " " + getMake() + " " + getModel() + " | FINE: $" + this.getCharge());
    }
}