package myPackage;

public class myMath {
    public static double  pow(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        else{
            return n * factorial(n - 1);
        }
    }
}
