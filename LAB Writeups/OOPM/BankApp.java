import java.util.Scanner;

class Customer {
    private String name;
    private String address;
    private Long phone;
    private String email;
    private String uid;
    private String pan;

    public Customer(String name, String address, Long phone, String email, String uid, String pan) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.uid = uid;
        this.pan = pan;
    }

    public void displayCustomer() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("UID: " + uid);
        System.out.println("PAN: " + pan);
    }
}

class Account {
    private static int nextAccountNumber = 1001;
    private int accountNumber;
    private Customer customer;
    private double balance;

    public Account(Customer customer) {
        this.accountNumber = nextAccountNumber++;
        this.customer = customer;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        customer.displayCustomer();
        System.out.println("Balance: ₹" + balance);
    }
}

class AccountManagement {
    private Account[] accounts;
    private int numberOfAccounts;

    public AccountManagement(int size) {
        accounts = new Account[size];
        numberOfAccounts = 0;
    }

    public void openAccount(String name, String address, Long phone, String email, String uid, String pan) {
        if (numberOfAccounts < accounts.length) {
            Customer customer = new Customer(name, address, phone, email, uid, pan);
            accounts[numberOfAccounts] = new Account(customer);
            System.out.println("Account created successfully with Account Number: " + accounts[numberOfAccounts].getAccountNumber());
            numberOfAccounts++;
        } else {
            System.out.println("Cannot create more accounts. Storage is full.");
        }
    }

    public Account findAccount(int accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void closeAccount(int accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                System.out.println("Closing account number: " + accountNumber);
                accounts[i] = accounts[numberOfAccounts - 1];
                numberOfAccounts--;
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void depositToAccount(int accountNumber, double amount, Scanner scanner) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found. Would you like to create a new account? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter customer address: ");
                String address = scanner.nextLine();
                System.out.print("Enter customer phone: ");
                Long phone = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Enter customer email: ");
                String email = scanner.nextLine();
                System.out.print("Enter customer UID: ");
                String uid = scanner.nextLine();
                System.out.print("Enter customer PAN: ");
                String pan = scanner.nextLine();

                openAccount(name, address, phone, email, uid, pan);
                accounts[numberOfAccounts - 1].deposit(amount);
            }
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount, Scanner scanner) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found. Would you like to create a new account? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter customer address: ");
                String address = scanner.nextLine();
                System.out.print("Enter customer phone: ");
                Long phone = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Enter customer email: ");
                String email = scanner.nextLine();
                System.out.print("Enter customer UID: ");
                String uid = scanner.nextLine();
                System.out.print("Enter customer PAN: ");
                String pan = scanner.nextLine();

                openAccount(name, address, phone, email, uid, pan);
                accounts[numberOfAccounts - 1].withdraw(amount);
            }
        }
    }

    public void displayAccountDetails(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAllAccounts() {
        if (numberOfAccounts == 0) {
            System.out.println("No accounts available.");
        } else {
            for (int i = 0; i < numberOfAccounts; i++) {
                accounts[i].displayAccountDetails();
                System.out.println();
            }
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManagement accountManagement = new AccountManagement(10);

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Open an account");
            System.out.println("2. Close an account");
            System.out.println("3. Display account details");
            System.out.println("4. Display all accounts");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    Long phone = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter customer UID: ");
                    String uid = scanner.nextLine();
                    System.out.print("Enter customer PAN: ");
                    String pan = scanner.nextLine();

                    accountManagement.openAccount(name, address, phone, email, uid, pan);
                    break;
                case 2:
                    System.out.print("Enter account number to close: ");
                    int accountNumberToClose = scanner.nextInt();
                    accountManagement.closeAccount(accountNumberToClose);
                    break;
                case 3:
                    System.out.print("Enter account number to display: ");
                    int accountNumberToDisplay = scanner.nextInt();
                    accountManagement.displayAccountDetails(accountNumberToDisplay);
                    break;
                case 4:
                    accountManagement.displayAllAccounts();
                    break;
                case 5:
                    System.out.print("Enter account number for deposit: ");
                    int accountNumberToDeposit = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accountManagement.depositToAccount(accountNumberToDeposit, depositAmount, scanner);
                    break;
                case 6:
                    System.out.print("Enter account number for withdrawal: ");
                    int accountNumberToWithdraw = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    accountManagement.withdrawFromAccount(accountNumberToWithdraw, withdrawalAmount, scanner);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

