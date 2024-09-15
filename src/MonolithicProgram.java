import java.util.Scanner;

public class MonolithicProgram {
    // One public attribute boolean
    public boolean feelingGood;

    public MonolithicProgram() {
        feelingGood = false;
    }
    
    public static void main(String[] args) throws InterruptedException {
        MonolithicProgram program1 = new MonolithicProgram();
        System.out.println(program1);

        // Compound Expressions
        // 8 * 6 - 14 % 3 + 8 / 2

        // Parenthesis always come first.
        // Then, multiplication, division, and modulus come first. 
        // Then addition and subtraction.
        // Then comes assignment operator. Works from right to left.

        // An example of how this is solved, and the raw equation.
        // int j = 8 * 6 - 14 % (3 + 8) / 2;
        // int i = 8 * 6;
        // int g = -14 % (3 + 8);
        // int h = 2;
        // System.out.println("How the equation is solved: " + i + g / h);
        // System.out.println("Same answer: " + j);

        // Another example of plugging in values by declaring variables.
        // int x = 3;
        // int y = 2;
        // System.out.println(8 * 6 - 14 % 3 + 8 / 2);
        // System.out.println(8 * 6 - 14 % (x + 8) / y);
        
        // Exception occurs when something happens that isn't supposed to, or can't handle.
        // Example: the program tries to divide by 0. This will throw an exception.
        /* int exception = 6 / 0;
        System.out.println(exception); */

        Scanner input = new Scanner(System.in);

        // int a;
        // int b;

        // // If left operand is less than right with %, the left is returned
        // System.out.println("Enter any digit: \n>>>");
        // a = input.nextInt();

        // System.out.println("Okay, you entered "+a+" for your first digit.");

        // System.out.println("Now, enter another digit: \n>>>");
        // b = input.nextInt();
        
        // while (b == 0) {
        //     System.out.println("You cannot divide by zero. Please try again.\n>>>");
        //     b = input.nextInt();
        // }

        // System.out.println("Nice! You entered "+b+" for you second digit.");

        // System.out.println("Alright, so, "+a+" divided by " +b+ " equals " + a % b+".");

        // Assignent operator works right to left.
        // int l = a = b = h = 4; 4 is assigned to h, which is assigned to b, which is assigned to a, which a equals l.

        // int firstValue = 13;
        // double secondValue = 18.5;
        // double sumOfValues = firstValue + secondValue;
        // System.out.println("First value plus second value equals " + sumOfValues+".");

        // int d;
        // int f;
        // d = f = 42;
        // System.out.println("Assigned both variables on one line: "+d+", "+f+".");

        // System.out.println("Sleeping...");
        // Thread.sleep(2000);
        // System.out.println("I took a power nap. zzz...");

        /* Compound expressions take the current value of the variable and add/sub/multiply/divide/mod to the variable and return that value.
         * x += 3 is the same as x = x + 3.
         * y = 1
         * x -= y is the same as x = x - y.
        */

        // int xx = 6;
        // xx += 7;
        // xx -= 3;
        // xx *= 10;
        // xx /= 5;
        // xx %= 3;
        // System.out.println("Woah..." + xx);

        /*
         * Increment and decrement variables by 1.
         * x++ is the same as x = x + 1.
         * x-- is the same as x = x - 1.
         */

        //  int test = 2;
        //  int test1 = 7;
        //  x++;
        //  y--;
        //  System.out.println(test);
        //  System.out.println(test1);

        //  int prefixTest1 = 3;
        //  int prefixTest2 = 3;
        //  prefixTest1++;
        //  prefixTest2--;
        //  System.out.printf("%s%d%n%s%d",
        //  "First digit: ",
        //  prefixTest1++,
        //  "Second digit: ",
        //  prefixTest2--);

         /**
          * int x = 23; Declaring an integer variable x which is equal to 23.
          * int y = 17; Declaring an integer variable y which is equal to 17.
          * x *= 4; taking the current value of x, multiplying it by 4, then assigning that new value to x. (x now equals 92)
          * y++ incrementing y by one and returning that value to y (y now equals 18)
          * x /= 3; taking the current value of x, dividing it by 3, then assigning that new value to x. (x now equals 9)
          * y -= 9; taking the current value of y, subtracting it by 9, then assigning that new value to y. (y now equals 9)
          * x %= y; taking the current value of x, using modulous by y, then assigning the remainder of x % y to x (x now equals 3)
          * System.out.println(x); Printing x.
          */

          // System.out.println("2 to the power of 2 is... " + Math.pow(2, 2)); Same as 2^2

          /*
           * CASTING NUMBERS
           * System.out.println(6 / 4) ; <-- both int values, will result in a integer
           * System.out.println(6.0 / 4); <-- first value is a double, will result in a double
           * System.out.println(6 / 4.0); <-- second value is a double, will result in a double
           * System.out.println((double)6 / 4) <-- both are integers, however, we CAST the first int to a double, so it will result in a double
           * double number = 11.0 / 4;
           * int roundedNumber = (int) (number + 0.5);
           * System.out.println("11.0 / 4 = " + number);
           * System.out.println("11 / 4 = " + (int)number);
           * System.out.println("11.0 / 4 rounded = " + roundedNumber)
           */
    }
}