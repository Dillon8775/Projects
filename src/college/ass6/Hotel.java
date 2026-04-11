package college.ass6;

// Dillon Craig Strickland
// 2/23/2025
// The hotel class, which stores the hotel name, days stayed and the daily lodging fee for the user's hotel.
public class Hotel {
    private String hotelName;
    private int daysStayed;
    private double dailyLodgingFee;

    public Hotel(String hotelName, int daysStayed, double dailyLodgingFee) {
        this.hotelName = hotelName;
        this.daysStayed = daysStayed;
        this.dailyLodgingFee = dailyLodgingFee;
    }

    public Hotel() {
        hotelName = "";
        daysStayed = 0;
        dailyLodgingFee = 0;
    }

    @Override
    public String toString() {
        return "Hotel Name: " + hotelName + "\nDays Stayed: " + daysStayed + "\nDaily Lodging Fee: " + dailyLodgingFee;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getDaysStayed() {
        return daysStayed;
    }

    public void setDaysStayed(int daysStayed) {
        this.daysStayed = daysStayed;
    }

    public double getDailyLodgingFee() {
        return dailyLodgingFee;
    }

    public void setDailyLodgingFee(double dailyLodgingFee) {
        this.dailyLodgingFee = dailyLodgingFee;
    }
}