package traffic;

// Dillon Craig Strickland
// 2/25/2025
// Printing out all forms of "Tickets".
public class TicketTest {

    public static void main(String[] args) {
        TimeExpiredTicket t1 = new TimeExpiredTicket("ABC-123", "Toyota", "Camry", "Silver");
        HandicappedTicket t2 = new HandicappedTicket("XYZ-789", "Ford", "F-150", "Black");
        FireLaneTicket t3 = new FireLaneTicket("HELP-911", "Tesla", "Model 3", "Red");

        // Report information
        System.out.println("--- Police Traffic Report ---");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
    }
}