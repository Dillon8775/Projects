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
            System.out.print("Enter assignment #" + (i + 1) + " grade.\n>>>");
            String input = scanner.next();
            int index = input.indexOf('/');
            m = Integer.parseInt(input.substring(index + 1));
            p = Integer.parseInt(input.substring(0, index));
            possiblePoints.add(m);
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

        String letterGrade;
        if (grade >= 95 && grade <= 100) {
            letterGrade = "A+";
        } else if (grade >= 90 && grade <= 94) {
            letterGrade = "A";
        } else if (grade >= 85 && grade <= 89) {
            letterGrade = "B+";
        } else if (grade >= 80 && grade <= 84) {
            letterGrade = "B";
        } else if (grade >= 75 && grade <= 79) {
            letterGrade = "C+";
        } else if (grade >= 70 && grade <= 74) {
            letterGrade = "C";
        } else if (grade >= 65 && grade <= 69) {
            letterGrade = "D+";
        } else if (grade >= 60 && grade <= 64) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        System.out.println("Total points possible: " + (int) totalPointsPossible);
        System.out.println("Total points earned: " + (int) totalPointsEarned + " (from " + assignmentNum + " assignments).");
        System.out.println("Your quarter grade is: " + grade + "% (" + letterGrade+")");
    }
}