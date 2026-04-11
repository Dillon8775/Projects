package college.util;

public class IMath {

    public static double toDecimal(double d) {
        return d / 100;
    }

    public static double toPercentage(double d) {
        return d * 100;
    }

    public static double round(double value, boolean tenthsPlace) {
        return tenthsPlace ? (double)Math.round(value * 10) / 10 : (double)Math.round(value * 100) / 100;
    }
}