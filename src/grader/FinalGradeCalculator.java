package grader;

import util.IMath;

import java.util.Scanner;

public class FinalGradeCalculator {

    public static void main(String[] args) {
        System.out.printf("%s%n%s%n%s", "Is there a final exam for this class?","Y = yes | N = no",">>>");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();

        boolean hasExam = input.equals("y");

        double examWeight = 0;
        double examScore = 0;
        if (hasExam) {
            System.out.printf("%s%n%s","How much is your exam worth (enter as a PERCENTAGE).",">>>");
            examWeight = scanner.nextDouble();
            examWeight = IMath.toDecimal(examWeight);
            System.out.printf("%s%n%s","Enter a hypothetical score for your exam (as a PERCENTAGE).",">>>");
            examScore = scanner.nextDouble();
            examScore = IMath.toDecimal(examScore);
            scanner.nextLine();
        }

        System.out.printf("%s%n%s%n%s", "Is this a semester-long class, or year-long class?","Y = year-long | S = semester-long",">>>");
        input = scanner.nextLine();
        input = input.toLowerCase();
        boolean yearLong = input.equals("y");

        double[] quarterGrades = new double[4];
        System.out.printf("%s%n%s","Enter your first quarter grade.",">>>");
        quarterGrades[0] = scanner.nextDouble();
        System.out.printf("%s%n%s","Enter your second quarter grade.",">>>");
        quarterGrades[1] = scanner.nextDouble();
        if (yearLong) {
            System.out.printf("%s%n%s","Enter your third quarter grade.",">>>");
            quarterGrades[2] = scanner.nextDouble();
            System.out.printf("%s%n%s","Enter your forth quarter grade.",">>>");
            quarterGrades[3] = scanner.nextDouble();
        }

        double finalGrade = 0;
        for (double quarterGrade : quarterGrades) {
            finalGrade += quarterGrade;
        }
        finalGrade /= yearLong ? 400 : 200;

        if (hasExam) {
            finalGrade = (finalGrade * (1 - examWeight)) + (examScore * examWeight);
        }

        finalGrade = IMath.toPercentage(finalGrade);

        System.out.print("Your final grade is:\n"+finalGrade+"%");
        scanner.close();
    }
}