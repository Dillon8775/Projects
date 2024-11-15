package util;

import java.util.Scanner;

public class SampleStatistics {

    public static void main(String[] args) {
        System.out.print("Enter denominator:\n>>>");
        Scanner scanner = new Scanner(System.in);
        double denominator = scanner.nextDouble();
        System.out.print("Enter numerator:\n>>>");
        double numerator = scanner.nextDouble();

        double p̂ = numerator / denominator;
        double p̂R = IMath.toPercentage(p̂);
        p̂R = Math.round(p̂R);

        double sep = Math.sqrt((p̂ * (1 - p̂)) / denominator);
        System.out.println("p̂ = " + p̂R + "% (" + p̂ + " as decimal)");
        System.out.println("SEP = " + sep);
        sep = IMath.round(sep, false);
        System.out.println("SEP (Rounded) = " + sep);
    }
}