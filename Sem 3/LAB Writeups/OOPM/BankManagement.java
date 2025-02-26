import java.util.*;

class Bank {
    String accName;
    Long accNumber;
    int balance;

    Bank(String accName, Long accNumber, int balance) {
        this.accName = accName;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public String getAccName() {
        return accName;
    }

    public Long getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdraw successful. New balance: " + balance);
        return true;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
}

public class BankManagement {
    private static ArrayList<Bank> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bank Management");

        boolean flag = true;

        while (flag) {
            System.out.println("\n1. Create");
            System.out.println("2. Delete account");
            System.out.println("3. Search Account");
            System.out.println("4. Withdraw");
            System.out.println("5. Deposit Amount");
            System.out.println("6. Sort Accounts by Name");
            System.out.println("7. Sort Accounts by Balance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    deleteAccount(sc);
                    break;
                case 3:
                    searchAccount(sc);
                    break;
                case 4:
                    withdrawAmount(sc);
                    break;
                case 5:
                    depositAmount(sc);
                    break;
                case 6:
                    sortAccountsByName();
                    break;
                case 7:
                    sortAccountsByBalance();
                    break;
                case 8:
                    flag = false;
                    System.out.println("Exiting... Thank you for using Bank Management!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void createAccount(Scanner sc) {
        System.out.print("Enter account name: ");
        String accName = sc.nextLine();
        System.out.print("Enter account number: ");
        Long accNumber = sc.nextLong();
        System.out.print("Enter initial balance: ");
        int balance = sc.nextInt();
        Bank newAccount = new Bank(accName, accNumber, balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }

    private static void deleteAccount(Scanner sc) {
        System.out.print("Enter account number to delete: ");
        Long accNumber = sc.nextLong();
        
        Iterator<Bank> iterator = accounts.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Bank account = iterator.next();
            if (account.getAccNumber().equals(accNumber)) {
                iterator.remove();
                System.out.println("Account deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }
    }

    private static void searchAccount(Scanner sc) {
        System.out.print("Enter account number to search: ");
        Long accNumber = sc.nextLong();
        
        for (Bank account : accounts) {
            if (account.getAccNumber().equals(accNumber)) {
                System.out.println("Account found: Name: " + account.getAccName() + ", Balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void withdrawAmount(Scanner sc) {
        System.out.print("Enter account number to withdraw from: ");
        Long accNumber = sc.nextLong();
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        for (Bank account : accounts) {
            if (account.getAccNumber().equals(accNumber)) {
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void depositAmount(Scanner sc) {
        System.out.print("Enter account number to deposit to: ");
        Long accNumber = sc.nextLong();
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();

        for (Bank account : accounts) {
            if (account.getAccNumber().equals(accNumber)) {
                account.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void sortAccountsByName() {
        Collections.sort(accounts, new Comparator<Bank>() {
            @Override
            public int compare(Bank account1, Bank account2) {
                return account1.getAccName().compareTo(account2.getAccName());  // Compare by account name
            }
        });
        displayAccounts("Name");
    }
    
    private static void sortAccountsByBalance() {
        Collections.sort(accounts, new Comparator<Bank>() {
            @Override
            public int compare(Bank account1, Bank account2) {
                return Integer.compare(account1.getBalance(), account2.getBalance());  // Compare by balance
            }
        });
        displayAccounts("Balance");
    }
    
    private static void displayAccounts(String sortType) {
        System.out.println("Accounts sorted by " + sortType + ":");
        for (Bank account : accounts) {
            System.out.println("Name: " + account.getAccName() +
                               ", Account Number: " + account.getAccNumber() +
                               ", Balance: " + account.getBalance());
        }
    }
}
