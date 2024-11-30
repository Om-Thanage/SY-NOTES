import java.util.*;

public class Happynumbers {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the number:\t");
        int num = s1.nextInt();
        s1.close();

        int result = num;
        
        while (result != 1 && result != 4) {
            result = square(result);
        }

        if (result == 1) {
            System.out.println(num + " is a Happy number.");
        } else {
            System.out.println(num + " is a Sad number.");
        }
    }

    static int square(int num) {
        int sum = 0;
        while (num > 0) {
            int last_digit = num % 10;
            sum += last_digit * last_digit;
            num /= 10;
        }
        return sum;
    }
}
