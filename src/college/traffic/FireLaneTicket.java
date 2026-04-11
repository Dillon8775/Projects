package college.traffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that the user parked near a fire lane or beside a fire hydrant. Charge of $150.
public class FireLaneTicket extends Ticket {

    public FireLaneTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 150);
    }

    @Override
    public String toString() {
        return "FIRE LANE TICKET - Tag: " + getTag() + " | Fine: $" + this.getCharge();
    }
}