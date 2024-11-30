//Base 10
import java.util.*;
public class Harshad10 {
    public static void main(String [] args){
        Scanner s1 = new Scanner(System.in);
        int num = s1.nextInt();
        int og_num = num;
        int sum = 0;
        while(num>0){
            int ld = num%10;
            num /=10;
            sum+=ld;
            System.out.print(ld);
        }
        if (og_num%sum == 0) System.out.println("Harshad no.");
        else System.out.println("Not Harshad no.");
        s1.close();
    }
}
