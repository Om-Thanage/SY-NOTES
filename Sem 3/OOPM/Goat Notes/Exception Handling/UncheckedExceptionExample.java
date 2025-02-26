public class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            // This will cause an ArithmeticException (division by zero)
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught an unchecked exception: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) throws ArithmeticException{
        return a / b; // Can throw ArithmeticException if b is zero
    }
}
