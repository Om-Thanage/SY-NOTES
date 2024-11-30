public class ErrorExample {
    public static void main(String[] args) {
        try {
            // This will cause a StackOverflowError due to infinite recursion
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("Caught an error: " + e.getMessage());
        }
    }

    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }
}

