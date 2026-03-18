package advancedreview;

// Dillon C Strickland
// 3/18/2025
// A basic rectangle, containing the width and height.
public class Rectangle {
    private double width = 1;
    private double height = 1;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (2 * width + 2 * height);
    }
}