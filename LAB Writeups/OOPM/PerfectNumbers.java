import java.util.*;

class PerfectNumbers {
  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    System.out.println("Enter the starting number");
    int start = s1.nextInt();
    System.out.println("Enter the ending number");
    int end = s1.nextInt();
    for (int i = start; i <= end; i++) {
      PerfectNumber(i);
    }
    s1.close();
  }

  static void PerfectNumber(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    if (sum == num) {
      System.out.println(num);
    }
  }
}