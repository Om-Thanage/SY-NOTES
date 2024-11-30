// Custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomCheckedExceptionExample {
    public static void main(String[] args) {
        try {
            registerUser("John", 15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
    }

    public static void registerUser(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("User must be at least 18 years old to register.");
        }
        System.out.println("User " + name + " registered successfully!");
    }
}

