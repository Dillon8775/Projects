package generics;

import java.io.Serializable;

/**
 * Print any type.
 */
public class Printer<T /* Bounded generic, only 1 class and as many interfaces. */ extends Number & Serializable> {
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}