import java.util.Random;
import java.util.Scanner;

public class MathGame {
    private static double firstNumber;
    private static double secondNumber;
    private static String operator;
    private static double correctAnswer;
    private static double userAnswer;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please type in your first number.");
        firstNumber = scanner.nextDouble();

        System.out.println("Now, choose your operator. +, -, * or /");
        operator = scanner.next();
        
        while (!Calculator.isValidOperator(operator)) {
            System.out.println("Please choose a valid operator.");
            operator = scanner.next();
        }

        System.out.println("Finally, choose your second number.");
        secondNumber = scanner.nextDouble();

        double result;
        switch (operator) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
            default -> {
                result = Double.NaN;
                System.out.println("Whoops, looks like there was an error calculating your equation.");
            }
        }

        System.out.println(firstNumber + " " + operator + " " + secondNumber + " " + "= " + result);

        System.out.println("Awesome! Now, time for a game.");
        System.out.println("What type of equation would you like to do? Pick from either +, -, * or /");

        operator = scanner.next();
        while (!Calculator.isValidOperator(operator)) {
            System.out.println("Hmm, looks like you didn't input a valid operator. Try again.");
            operator = scanner.next();
        }

        System.out.println("Excellent! now, solve the equation below.");

        setNumberParameters(25, 10);
        refreshCorrectAnswer();

        tellEquation();
        userAnswer = scanner.nextDouble();
        scanForAnswer();

        System.out.println("Now, let's try something a little bit harder.");

        setNumberParameters(250, 50);
        runEquation();

        System.out.println("Ok... nice job, lets try something even HARDER.");
        setNumberParameters(10000, 1000);
        runEquation();

        System.out.println("Nice job! You passed.");

        int sqrtNumber = 25;
        correctAnswer = Math.sqrt(sqrtNumber);
        System.out.println("Now, what is the square root of " + sqrtNumber + "?");
        userAnswer = scanner.nextInt();
        scanForAnswer();

        sqrtNumber = 625;
        System.out.println("Great job! Now, what is the square root of " + sqrtNumber + "?");
        correctAnswer = Math.sqrt(sqrtNumber);
        userAnswer = scanner.nextInt();
        scanForAnswer();
    }

    private static void runEquation() {
        refreshCorrectAnswer();
        tellEquation();
        userAnswer = scanner.nextDouble();
        scanForAnswer();
    }

    private static void tellEquation() {
        System.out.println(firstNumber + " " + operator + " " + secondNumber);
    }

    private static void scanForAnswer() {
        boolean correct = userAnswer == correctAnswer;
        if (correct) {
            System.out.println("Good job! You got it right!");
        } else {
            System.out.println("Oof, you got it wrong.");
            System.out.println("The correct answer was " + correctAnswer);
        }
    }

    private static void setNumberParameters(int addOrSub, int multiOrDiv) {
        switch (operator) {
            case "+", "-" -> {
                firstNumber = random.nextInt(addOrSub);
                secondNumber = random.nextInt(addOrSub);
                if (operator.equals("-") && secondNumber > firstNumber) {
                    secondNumber = --firstNumber;
                }
            }
            case "*", "/" -> {
                firstNumber = random.nextInt(multiOrDiv);
                secondNumber = random.nextInt(multiOrDiv);
            }
        }
    }

    private static void refreshCorrectAnswer() {
        switch (operator) {
            case "+" -> correctAnswer = firstNumber + secondNumber;
            case "-" -> correctAnswer = firstNumber - secondNumber;
            case "*" -> correctAnswer = firstNumber * secondNumber;
            case "/" -> correctAnswer = firstNumber / secondNumber;
            default -> correctAnswer = Double.NaN;
        }
    }

    private static void exit() {
        System.exit(0);
    }
}