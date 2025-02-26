class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}

public class SecurityApp {
    public static void main(String[] args) {
        try {
            accessResource("guest");
        } catch (UnauthorizedAccessException e) {
            System.out.println("Security Alert: " + e.getMessage());
        }
    }

    public static void accessResource(String role) {
        if (!role.equals("admin")) {
            throw new UnauthorizedAccessException("Access denied: Admin role required.");
        }
        System.out.println("Resource accessed successfully!");
    }
}

