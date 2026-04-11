package college.searching;

// Dillon Strickland
// 4/10/2026
// A basic item class, which holds a UPC, weight and price.
public class Item {
    private int upc;
    private String weight;
    private double price;

    public Item(int upc, String weight, double price) {
        this.upc = upc;
        this.weight = weight;
        this.price = price;
    }

    public int getUpc() {
        return upc;
    }

    public String getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}