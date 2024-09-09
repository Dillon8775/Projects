import java.util.Scanner;

public class HelloWorld {
    private final int TOTAL_TIRES = 4; // you can also declare variables right here

    /**
     * Main method can go in any script.
     * This is where the code starts running.
     */
    public static void main(String[] args) {
        /*
        System.out.print("AP ");
        System.out.print("CS ");
        System.out.print("A ");
        System.out.println("Rocks!");
        System.out.println("Hello world");

        // 1st arg = format specifier, 2nd arg objects to be printed
        System.out.printf("%s%n%s", "Hello world!", "WOOOO!");

        FindTheBugs.run();
        StringLiterals.run();

        // Three primitives we will learn are int, doubles, and boolean
        int marbles = 10602;
        double avgScore = 95.8D; // uses 64-bits
        boolean hasSugar = false;

        float averageScore1 = 95.8F; // uses 32-bits
        */

        Scanner input = new Scanner(System.in);
        /*
        System.out.println("Enter in your age.\n>>>");
        int age;
        age = input.nextInt();
        System.out.println("You are "+age+" years old.");
         */

        System.out.println("Enter a number.");
        double num1 = input.nextDouble();

        System.out.println("Now, enter an operator.");
        String operator = input.next();
        
        System.out.println("Now, enter another number to add/multiply/divide/subtract/mod.");
        double num2 = input.nextDouble();

        double answer = 0;
        if (operator.equals("+")) {
            answer = num1 + num2;
        } else if (operator.equals("-")) {
            answer = num1 - num2;
        } else if (operator.equals("*")) {
            answer = num1 * num2;
        } else if (operator.equals("/")) {
            answer = num1 / num2;
        } else if (operator.equals("%")) {
            answer = num1 % num2;
        } else {
            System.out.println("It seems you have inputted an invalid operator. Please try again.");
            System.exit(0);
        }
        System.out.println("The answer to your equation is "+answer+".");
    }

    /*
     * boolean represents "true" or "false" (1 bit = 0.125 bytes).
     * ints represent whole numbers (32 bit = 4 bytes).
     * doubles represent decimal/floating-point numbers (64 bit = 8 bytes).
     * Strings are a represent-type of data. Booleans, ints, and doubles are all primitive.
     
     * + addition
     * - subtraction
     * * multiplication
     * / division
     * % modulus (returns the remainder of a divison problem) 
      
     * 17 % 5 -> 5square17 - 15 = 2, remainder = 2
     
     * int + int = int
     * double + double = double
     * double + int = double (casts to the higher number)

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