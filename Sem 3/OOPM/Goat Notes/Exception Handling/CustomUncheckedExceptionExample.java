// Custom unchecked exception
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class CustomUncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            withdraw(1000, 500);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }

    public static void withdraw(int amount, int balance) {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. You tried to withdraw " + amount + ", but balance is only " + balance);
        }
        System.out.println("Withdrawal successful! Remaining balance: " + (balance - amount));
    }
}
