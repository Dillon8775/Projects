// Imports go here

public class HelloWorld {
    private final int TOTAL_TIRES = 4; // you can also declare variables right here

    /**
     * Main method can go in any script.
     * This is where the code starts running.
     */
    public static void main(String[] args) {
        System.out.print("AP ");
        System.out.print("CS ");
        System.out.print("A ");
        System.out.println("Rocks!");
        System.out.println("Hello world");

        // 1st arg = format specifier, 2nd arg objects to be printed
        System.out.printf("%s%n%s", "Hello world!", "WOOOO!");

        // Three primitives we will learn are int, doubles, and boolean
        int marbles = 10602;
        double avgScore = 95.8D; // uses 64-bits
        boolean hasSugar = false;

        float averageScore1 = 95.8F; // uses 32-bits
    }

    /*
     * boolean represents "true" or "false" (1 bit = 0.125 bytes).
     * ints represent whole numbers (32 bit = 4 bytes).
     * doubles represent decimal/floating-point numbers (64 bit = 8 bytes).
     * Strings are a represent-type of data. Booleans, ints, and doubles are all primitive.

     * a variable declared as "final" cannot be changed.
     * a variable/method declared as "static" can be referenced from anywhere in the program, and does not need an object to be called
     (as long as the method has the access modifier "public").
     * a variable/method declared as "protected" can only be referenced in the package that the class is in.
     * a variable/method declared as "private" can only be referenced in the class that the variable is in.

     * Syntax error: will cause compliation failure.
     * Exceptions occur while the program is running and will cause the program to terminate abnormally. A program "throws an exception."
     * Logic error: is largely either coder or user driven (bad logic or unexpected output).
    
     * Single quotes are char objects.
     * System.out.printf is more powerful.

     * Curly braces are super important in Java as they allow the compiler to identify
    methods, functions, loops, and conditionals (blocks of code).
    */
}