public class ExceptionPropagationExample {

    public static void main(String[] args) {
        try {
            method1();
        } catch (ArithmeticException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        // Exception occurs here (division by zero)
        int result = 10 / 0;
    }
}
