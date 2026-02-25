package abstracttraffic;

// Dillon Craig Strickland
// 2/25/2025
// Printing out all forms of "AbstractTickets".
public class AbstractTrafficTest {

    public static void main(String[] args) {
        AbstractTicket[] ticketList = new AbstractTicket[3];

        ticketList[0] = new TimeExpiredTicket("ABC-123", "Toyota", "Camry", "Silver");
        ticketList[1] = new HandicappedTicket("XYZ-789", "Ford", "F-150", "Black");
        ticketList[2] = new FireLaneTicket("HELP-911", "Tesla", "Model 3", "Red");

        System.out.println("--- Processing Digital Tickets ---");

        for (AbstractTicket t : ticketList) {
            t.printTicket();
        }
    }
}