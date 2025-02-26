import java.util.*;
public class Harshad2 {
    public static void main(String [] args){
        Scanner s1 = new Scanner(System.in);
        int num = s1.nextInt();
        int og_num = num;
        int sum = 0;
        while(num>0){
            int ld = num%2;
            num /=2;
            sum+=ld;
            
        }
        if (og_num%sum == 0) System.out.println("Harshad no.");
        else System.out.println("Not Harshad no.");
        s1.close();
    }
}
