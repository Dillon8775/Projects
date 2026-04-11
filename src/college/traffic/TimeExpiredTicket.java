package college.traffic;

// Dillon Craig Strickland
// 2/25/2025
// A ticket that shows that the car was parked too long. Charge of $50.
public class TimeExpiredTicket extends Ticket {

    public TimeExpiredTicket(String tag, String make, String model, String color) {
        super(tag, make, model, color, 50);
    }

    @Override
    public String toString() {
        return "EXPIRED METER TICKET - Tag: " + getTag() + " | Fine: $" + this.getCharge();
    }
}