package college.traffic;

// Dillon Craig Strickland
// 2/25/2025
// A representation of a ticket class, which includes everything that a ticket may contain when getting fined.
public class Ticket {
    private String tag;
    private String make;
    private String model;
    private String color;
    private final int charge;

    public Ticket(String tag, String make, String model, String color, int charge) {
        this.tag = tag;
        this.make = make;
        this.model = model;
        this.color = color;
        this.charge = charge;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCharge() {
        return charge;
    }
}