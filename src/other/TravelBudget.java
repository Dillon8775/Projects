package other;

import java.util.Scanner;

public class TravelBudget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of days for your trip:\n>>>");

        int days = scanner.nextInt();

        System.out.println("Enter daily price for hotel:\n>>>");

        double price = scanner.nextDouble();

        System.out.println("Enter amount of miles you will drive:\n>>>");

        int miles = scanner.nextInt();

        double hotelPrice = days * price;
        double reimbursement = miles * 0.52;
        double totalPrice = hotelPrice + reimbursement;

        hotelPrice = Math.round(hotelPrice * 100) / 100.0;
        reimbursement = Math.round(reimbursement * 100) / 100.0;
        totalPrice = Math.round(totalPrice * 100) / 100.0;
        System.out.println("Hotel Price: $" + hotelPrice);
        System.out.println("Reimbursement: $" + reimbursement);
        System.out.println("Total Price: $" + totalPrice);
    }
}