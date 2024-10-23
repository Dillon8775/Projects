package grader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of assignments that you are going to input.");
        int assignmentNum = scanner.nextInt();

        List<Double> earnedPoints = new ArrayList<>();
        List<Double> possiblePoints = new ArrayList<>();
        double p, m;
        for (int i = 0; i < assignmentNum; i++) {
            System.out.println("Enter the maximum amount of points possible for assignment " + (i + 1) + ".");
            m = scanner.nextDouble();
            possiblePoints.add(m);
            System.out.println("Great! Now, enter the points that you earned for assignment " + (i + 1) + ".");
            p = scanner.nextDouble();
            earnedPoints.add(p);
        }

        double totalPointsEarned = 0;
        for (double earnedPoint : earnedPoints) {
            totalPointsEarned += earnedPoint;
        }

        double totalPointsPossible = 0;
        for (double possiblePoint : possiblePoints) {
            totalPointsPossible += possiblePoint;
        }

        double grade = totalPointsEarned / totalPointsPossible;
        grade = grade * 100;

        System.out.println("Total points possible: " + totalPointsPossible);
        System.out.println("Total points earned: " + totalPointsEarned);
        System.out.println("Your quarter grade is: " + grade + "%");
    }
}