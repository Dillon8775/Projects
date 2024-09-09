import java.util.Scanner;

public class MonolithicProgram {
    
    public static void main(String[] args) {
        // Compound Expressions
        // 8 * 6 - 14 % 3 + 8 / 2

        // Parenthesis always come first.
        // Then, multiplication, division, and modulus come first. 
        // Then addition and subtraction.
        // Then comes assignment operator. Works from right to left.

        // An example of how this is solved, and the raw equation.
        int j = 8 * 6 - 14 % (3 + 8) / 2;
        int i = 8 * 6;
        int g = -14 % (3 + 8);
        int h = 2;
        System.out.println("How the equation is solved: " + i + g / h);
        System.out.println("Same answer: " + j);

        // Another example of plugging in values by declaring variables.
        int x = 3;
        int y = 2;
        System.out.println(8 * 6 - 14 % 3 + 8 / 2);
        System.out.println(8 * 6 - 14 % (x + 8) / y);
        
        // Exception occurs when something happens that isn't supposed to, or can't handle.
        // Example: the program tries to divide by 0. This will throw an exception.
        /* int exception = 6 / 0;
        System.out.println(exception); */

        Scanner input = new Scanner(System.in);

        int a;
        int b;

        // If left operand is less than right with %, the left is returned
        System.out.println("Enter any digit: \n>>>");
        a = input.nextInt();

        System.out.println("Okay, you entered "+a+" for your first digit.");

        System.out.println("Now, enter another digit: \n>>>");
        b = input.nextInt();
        
        while (b == 0) {
            System.out.println("You cannot divide by zero. Please try again.\n>>>");
            b = input.nextInt();
        }

        System.out.println("Nice! You entered "+b+" for you second digit.");

        System.out.println("Alright, so, "+a+" divided by " +b+ " equals " + a % b+".");

        // Assignent operator works right to left.
        int l = a = b = h = 4; // 4 is assigned to h, which is assigned to b, which is assigned to a, which a equals l.

        int firstValue = 13;
        double secondValue = 18.5;
        double sumOfValues = firstValue + secondValue;
        System.out.println("First value plus second value equals " + sumOfValues+".");

        int d;
        int f;
        d = f = 42;
        System.out.println("Assigned both variables on one line: "+d+", "+f+".");
    }
}