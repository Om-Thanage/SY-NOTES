import myPackage.myMath;
import java.util.Scanner;

public class PackageMain {

    public static double computeCosine(double x, int n) {
        double cos = 1;
        int sign = -1;
        
        for (int i = 1; i < n; i++) {
            int power = 2 * i;
            double term = sign * (myMath.pow(x, power) / myMath.factorial(power));
            cos += term;
            sign *= -1;
        }
        return cos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the value of x (in degrees): ");
        double xDegrees = sc.nextDouble();
        System.out.print("Enter the number of terms (n): ");
        int n = sc.nextInt();
        sc.close();
        
        double PI = 3.141592653589793;
        double rad = PI * xDegrees / 180;
        
        double cosineValue = computeCosine(rad, n);
        System.out.println("The value of cos(" + xDegrees + ") degrees up to " + n + " terms is: " + cosineValue);
    }
}
