package lambda;

public class Lambdas {

    /**
     * Lambas allow us to directly implement our own implementation without having to manually declare that implementation.
     */
    public static void main(String[] args) {
        Cat myCat = new Cat();
        // printThing(myCat); We don't need to do this, because we can use a lamba expression to directly implement our implementation.

        // We can do this instead!
        printThing((s) -> {
            // The "s" is our parameter (in this case, a String).
            System.out.println("Meow " + s);
        });

        // We can also do it this way!
        Printable lambaPrintable = s -> System.out.println("MEOOWW!!!");
        printThing(lambaPrintable);
    }

    /**
     * Any object that implements {@link Printable} can be passed through this method.
     */
    static void printThing(Printable printable) {
        printable.print("!");
    }
}