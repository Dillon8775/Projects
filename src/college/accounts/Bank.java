package college.accounts;

// Dillon Craig Strickland
// 2/25/2025
// Testing all iMailables and printing them out correctly.
public class Bank {

    public static void main(String[] args) {
        iMailable[] mailable = new iMailable[2];

        mailable[0] = new MAccount("Bobby", 1000);
        mailable[1] = new CarLoan("Toyota", 500, 20, 216);

        for (iMailable m : mailable) {
            m.printStatement();
        }
    }
}