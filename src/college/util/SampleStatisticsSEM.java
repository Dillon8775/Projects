package college.util;

import java.util.Scanner;

public class SampleStatisticsSEM {

    public static void main(String[] args) {
        System.out.print("Enter denominator:\n>>>");
        Scanner scanner = new Scanner(System.in);
        double denominator = scanner.nextDouble();
        System.out.print("Enter standard deviation:\n>>>");
        double standardDeviation = scanner.nextDouble();

        double sem = standardDeviation / Math.sqrt(denominator);
        System.out.println("SEM = " + sem);
        sem = IMath.round(sem, false);
        System.out.println("SEM (Rounded) = " + sem);
    }
}