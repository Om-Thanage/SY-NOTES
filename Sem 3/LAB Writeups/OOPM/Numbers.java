import java.util.Scanner;

public class Numbers {
    double num1, num2, num3;
    public Numbers(double a, double b, double c) {
        num1 = a;
        num2 = b;
        num3 = c;
    }
    public double largest() {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = s1.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = s1.nextDouble();
        System.out.print("Enter the third number: ");
        double num3 = s1.nextDouble();
        Numbers large = new Numbers(num1, num2, num3);
        System.out.println("The largest number is: " + large.largest());
        s1.close();
    }
}
