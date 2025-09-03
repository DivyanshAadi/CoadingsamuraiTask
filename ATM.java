import java.util.*;

class BankAccount {
    private double balance;
    private ArrayList<String> transactions;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("⚠ Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: " + balance);
    }

    public void printTransactions() {
        System.out.println("📜 Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple login (PIN = 1234)
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        if (pin != 1234) {
            System.out.println("❌ Wrong PIN! Access Denied.");
            return;
        }

        BankAccount account = new BankAccount(1000.0); // Initial balance
        int choice;

        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double wdr = sc.nextDouble();
                    account.withdraw(wdr);
                    break;
                case 4:
                    account.printTransactions();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
