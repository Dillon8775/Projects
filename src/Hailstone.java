public class Hailstone {

    public static void main(String[] args) {
        // Hailstone1: Check if all integers reach the cycle
        boolean allReachCycle = hailstone1();
        String reached = allReachCycle ? "YES" : "NO";
        System.out.println("Hailstone1: Do all integers from 1 to 200 reach the cycle? " + reached);

        // Hailstone2: Find the maximum steps and starting number
        int[] result = hailstone2();
        System.out.println("Hailstone2: Maximum steps = " + result[0] + ", Starting number = " + result[1]);
    }

    // Method to equate the hailstone numbers (if even, multiply by 2, if odd, divide by 3 and add 2)
    public static int hailstoneSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }
        return steps;
    }

    // Method to check if all integers from 1 to 200 reach the cycle 4, 2, 1
    public static boolean hailstone1() {
        for (int i = 1; i <= 200; i++) {
            if (hailstoneSteps(i) == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find the maximum steps and the starting number that produces them
    public static int[] hailstone2() {
        int maxSteps = 0;
        int startingNumber = 0;
        for (int i = 1; i <= 200; i++) {
            int steps = hailstoneSteps(i);
            if (steps > maxSteps) {
                maxSteps = steps;
                startingNumber = i;
            }
        }
        return new int[]{maxSteps, startingNumber};
    }
}