package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        System.out.println("Printing integer...");
        IntegerPrinter printer = new IntegerPrinter(23);
        printer.print();

        System.out.println("---\nUsing generic printer to print integer...");
        Printer<Integer> genericPrinter = new Printer<>(56);
        genericPrinter.print();

        shout("John", 6);
        shout(1, "74");
        shout(3.6F, "Woaaah!!!");

        List<String> stringList = new ArrayList<>();
        stringList.add("615");
        stringList.add("Hello!11!!");

        printList(stringList);

        List<Integer> intList = new ArrayList<>();
        intList.add(5142);
        intList.add(49692);
        intList.add(7);

        printListNumber(intList);
    }

    // Returns type T, prints out type T and V.
    private static <T, V> T shout(T thingToShout, V otherThingToShout) {
        System.out.println(thingToShout + "!!!!!!");
        System.out.println(otherThingToShout + "!!!!!!!!");
        return thingToShout;
    }

    // Use a wild card (a question mark) when you don't know what generic type you are using.
    private static void printList(List</* Wild card --> */ ?> listToPrint) {
        System.out.println(listToPrint);
    }

    // Print type Number.
    private static void printListNumber(List<? extends Number> listToPrint) {
        System.out.println(listToPrint);
    }
}