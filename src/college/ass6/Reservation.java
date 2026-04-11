package college.ass6;

// Dillon Craig Strickland
// 2/23/2025
// The Reservation class, which stores the user's name, flight data, and hotel (room) data.
public class Reservation {
    private String custerName;
    private Flight flight;
    private Hotel room;

    public Reservation(String custerName, Flight flight, Hotel room) {
        this.custerName = custerName;
        this.flight = flight;
        this.room = room;
    }

    public Reservation() {
        this.custerName = "Bobby";
        this.flight = new Flight();
        this.room = new Hotel();
    }

    @Override
    public String toString() {
        return "Customer Name: " + custerName + "\nFlight: " + flight.toString() + "\nHotel: " + room.toString();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getRoom() {
        return room;
    }

    public void setRoom(Hotel room) {
        this.room = room;
    }

    public String getCusterName() {
        return custerName;
    }

    public void setCusterName(String custerName) {
        this.custerName = custerName;
    }
}
