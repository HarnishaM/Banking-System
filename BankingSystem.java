import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class BankingSystem {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int transactionCounter = 1;

    // Add a new account
    public void addAccount(Account account) {
        if (accounts.containsKey(account.getId())) {
            System.out.println("Account with this ID already exists.");
        } else {
            accounts.put(account.getId(), account);
            System.out.println("Account added successfully.");
        }
    }

    // Remove an account
    public void removeAccount(int accountId) {
        if (accounts.remove(accountId) != null) {
            System.out.println("Account removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Update account details
    public void updateAccount(int accountId, Account updatedAccount) {
        if (accounts.containsKey(accountId)) {
            accounts.put(accountId, updatedAccount);
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Deposit funds into an account
    public void depositFunds(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            transactions.add(new Transaction(transactionCounter++, accountId, "Deposit", amount, new Date()));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw funds from an account
    public void withdrawFunds(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                transactions.add(new Transaction(transactionCounter++, accountId, "Withdrawal", amount, new Date()));
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer funds between accounts
    public void transferFunds(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                transactions.add(new Transaction(transactionCounter++, fromAccountId, "Transfer Out", amount, new Date()));
                transactions.add(new Transaction(transactionCounter++, toAccountId, "Transfer In", amount, new Date()));
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient balance for transfer.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }
   
}
