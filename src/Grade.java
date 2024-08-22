import java.util.Scanner;

/**
 * Grade an assignment!
 */
public class Grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What was the maximum amount of points on this assignment?");
        double maxPoints = scanner.nextDouble();

        System.out.println("What did you make on the assignment?");
        double grade = scanner.nextDouble();

        double percentage = (grade / maxPoints) * 100;
        System.out.println("You scored " + grade + "/" + maxPoints + ", which means you made a " + percentage + "%.");
        scanner.close();
    }
}