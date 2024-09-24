package generics;

/**
 * <p>What if we wanted to print different types of objects?
 * <p>This could lead to a bunch of code duplication, so lets instead use {@code generics.}
 */
@Deprecated
public class IntegerPrinter {
    Integer thingToPrint;

    public IntegerPrinter(Integer thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}