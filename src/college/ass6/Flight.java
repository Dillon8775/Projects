package college.ass6;

// Dillon Craig Strickland
// 2/23/2025
// The Flight class, which stores the airlines, flight number, and flight fare for the user.
public class Flight {
    private String airlines;
    private int flightNum;
    private double flightFare;

    public Flight(String airlines, int flightNum, double flightFare) {
        this.airlines = airlines;
        this.flightNum = flightNum;
        this.flightFare = flightFare;
    }

    public Flight() {
        flightFare = 0;
        airlines = "";
        flightNum = 0;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public double getFlightFare() {
        return flightFare;
    }

    public void setFlightFare(double flightFare) {
        this.flightFare = flightFare;
    }

    @Override
    public String toString() {
        return "\nAirlines: " + airlines + "\nFlight #: " + flightNum + "\nFlight Fare: " + flightFare + "\n";
    }
}