import java.util.Scanner;

public class Banking_Management_System{
    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Banking App");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deposit(sc);
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            if (amount <= balance) {
                balance =balance - amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    private static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
