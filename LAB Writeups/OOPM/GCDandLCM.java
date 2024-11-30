import java.util.*;

class GCDandLCM{
  public static void main(String [] args){
    Scanner s1 = new Scanner (System.in);
    System.out.println("Enter the first number:\t");
    int num1 = s1.nextInt();
    System.out.println("Enter the second number:\t");
    int num2 = s1.nextInt();
    
    int gcd = GCD(num1, num2);
    System.out.println("GCD = " + gcd);
    System.out.println("LCM = " + (num1 * num2) / gcd);
    
    s1.close();
  }

  static int GCD(int num1, int num2){
    if (num2 != 0) {
      return GCD(num2, num1 % num2);
    } else {
      return num1;
    }
  }
}
