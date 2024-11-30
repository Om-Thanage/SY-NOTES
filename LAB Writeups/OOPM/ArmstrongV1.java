//Version 1 
import java.util.*;
class ArmstrongV1{
    public static void main(String [] args){
        Scanner s1 = new Scanner (System.in);
        System.out.println("Enter the number:\t");
        int num = s1.nextInt();
        int count = 0, last_digit, sum =0, og_num = num;
        while(num>0){
            count++;
            num /=10;
        }
        num = og_num;
        
        System.out.println("Number of digits = "+count);
        for(int i = 0; i<count; i++){
            last_digit = num%10;
            num /=10;
            sum += (int)Math.pow(last_digit, count);

        }

        if (sum == og_num) {
            System.out.println("Yes, the given number is an Armstrong Number");
        }
        else{
             System.out.println("No, the given number is not an Armstrong Number");
        }
        s1.close();
    }
}