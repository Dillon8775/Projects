package college.ass6;

import java.util.Scanner;

// Dillon Craig Strickland
// 2/23/2025
// The main entrypoint of the TravelAgent program, where the user enters their name to get a reservation.
public class TravelAgent {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name:\n>>>");
        String userName = input.nextLine();

        Reservation reservation = new Reservation(userName, new Flight(), new Hotel("Smack", 5, 1.5));
        System.out.println(reservation.toString());
    }
}