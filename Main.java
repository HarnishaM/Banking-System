import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample interaction with the system
        try {
            while (true) {
                System.out.println("Banking System Menu:");
                System.out.println("1. Add Account");
                System.out.println("2. Remove Account");
                System.out.println("3. Update Account");
                System.out.println("4. Deposit Funds");
                System.out.println("5. Withdraw Funds");
                System.out.println("6. Transfer Funds");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter Account ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        System.out.print("Enter Initial Balance: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Account Type (Savings/Checking): ");
                        String accountType = scanner.nextLine();
                        system.addAccount(new Account(id, customerId, balance, accountType));
                        break;

                    case 2:
                        System.out.print("Enter Account ID to Remove: ");
                        int removeId = scanner.nextInt();
                        system.removeAccount(removeId);
                        break;

                    case 3:
                        System.out.print("Enter Account ID to Update: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter New Customer ID: ");
                        int newCustomerId = scanner.nextInt();
                        System.out.print("Enter New Balance: ");
                        double newBalance = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter New Account Type (Savings/Checking): ");
                        String newAccountType = scanner.nextLine();
                        system.updateAccount(updateId, new Account(updateId, newCustomerId, newBalance, newAccountType));
                        break;

                    case 4:
                        System.out.print("Enter Account ID to Deposit: ");
                        int depositId = scanner.nextInt();
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        system.depositFunds(depositId, depositAmount);
                        break;

                    case 5:
                        System.out.print("Enter Account ID to Withdraw: ");
                        int withdrawId = scanner.nextInt();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        system.withdrawFunds(withdrawId, withdrawAmount);
                        break;

                    case 6:
                        System.out.print("Enter From Account ID: ");
                        int fromAccountId = scanner.nextInt();
                        System.out.print("Enter To Account ID: ");
                        int toAccountId = scanner.nextInt();
                        System.out.print("Enter Amount to Transfer: ");
                        double transferAmount = scanner.nextDouble();
                        system.transferFunds(fromAccountId, toAccountId, transferAmount);
                        break;

                    case 7:
                        System.out.println("Exiting the system. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data types.");
        } finally {
            scanner.close();
        }
    }
}
