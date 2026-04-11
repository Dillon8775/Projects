package college.traffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that an unhandicapped user marked in a handicapped spot. Charge of $100.
public class HandicappedTicket extends Ticket {

    public HandicappedTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 100);
    }

    @Override
    public String toString() {
        return "HANDICAPPED ZONE TICKET - Tag: " + getTag() + " | Fine: $" + this.getCharge();
    }
}