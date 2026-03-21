package advancedreview;

// Dillon C. Strickland
// March 21st, 2026
// A class to display information about an apartment, containing the address, building #, and total amount of units and square footage.
// We use inner classes for simplification.
public class TestApartmentBuilding {

    public static void main(String[] args) {
        Address address = new Address("123", "Oak St", "Winston-Salem", "N.C.", "27107");
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(address, 10000, 5);

        System.out.println(apartmentBuilding);
    }

    static class Address {
        private String houseNumber;
        private String streetName;
        private String city;
        private String state;
        private String zip;

        public Address(String houseNumber, String streetName, String city, String state, String zip) {
            setHouseNumber(houseNumber);
            setStreetName(streetName);
            setCity(city);
            setState(state);
            setZip(zip);
        }

        @Override
        public String toString() {
            return "House Number: " + houseNumber + "\nStreet Name: " + streetName + "\nCity: " + city + "\nState: " + state + "\nZIP Code: " + zip;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    static class Building {
        private Address buildingAddress;
        private int squareFootage;

        public Building(Address buildingAddress, int squareFootage) {
            this.buildingAddress = buildingAddress;
            this.squareFootage = squareFootage;
        }

        public Address getBuildingAddress() {
            return buildingAddress;
        }

        public void setBuildingAddress(Address buildingAddress) {
            this.buildingAddress = buildingAddress;
        }

        public int getSquareFootage() {
            return squareFootage;
        }

        public void setSquareFootage(int squareFootage) {
            this.squareFootage = squareFootage;
        }

        @Override
        public String toString() {
            return buildingAddress.toString() + "\nSquare Footage: " + squareFootage;
        }
    }

    static class ApartmentBuilding extends Building {
        private int totalUnits;

        public ApartmentBuilding(Address buildingAddress, int squareFootage, int totalUnits) {
            super(buildingAddress, squareFootage);
            setTotalUnits(totalUnits);
        }

        public int getTotalUnits() {
            return totalUnits;
        }

        public void setTotalUnits(int totalUnits) {
            this.totalUnits = totalUnits;
        }

        @Override
        public String toString() {
            return super.toString() + "\nTotal Units: " + totalUnits;
        }
    }
}