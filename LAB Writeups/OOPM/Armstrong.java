//Version 1 
// import java.util.*;
// class Armstrong{
//     public static void main(String [] args){
//         Scanner s1 = new Scanner (System.in);
//         System.out.println("Enter the number:\t");
//         int num = s1.nextInt();
//         int count = 0, last_digit, sum =0, og_num = num;
//         while(num>0){
//             count++;
//             num /=10;
//         }
//         num = og_num;
        
//         System.out.println("Number of digits = "+count);
//         for(int i = 0; i<count; i++){
//             last_digit = num%10;
//             num /=10;
//             sum += (int)Math.pow(last_digit, count);

//         }

//         if (sum == og_num) {
//             System.out.println("Yes, the given number is an Armstrong Number");
//         }
//         else{
//              System.out.println("No, the given number is not an Armstrong Number");
//         }
//     }
// }

//Version 2
// import java.util.*;
// class Armstrong{
//     public static void main(String [] args){
//         Scanner s1 = new Scanner (System.in);
//         System.out.println("Enter the number:\t");
//         int num = s1.nextInt();
//         int count = 0, og_num = num;
//         while(num>0){
//             count++;
//             num /=10;
//         }
//         System.out.println("Number of digits = "+count);
//         if(checkArmstrong(og_num, count)) {
//             System.out.println("Yes, the given number is an Armstrong Number");
//         }
//         else{
//             System.out.println("No, the given number is not an Armstrong Number");
//         }

//         s1.close();
        
        
        
        
//     }
//     static boolean checkArmstrong(int num, int count){
//         int last_digit = 0, sum = 0, og_num = num;
//         for(int i = 0; i<count; i++){
//             last_digit = num%10;
//             num /=10;
//             sum += (int)Math.pow(last_digit, count);

//         }

//         if (sum == og_num) {
//             return true;
//         }
//         else{
//              return false;
//         }
//     }
// }

//Version 3 Creating 2 different classes
// import java.util.*;
// class Armstrong{
//     public static void main(String [] args){
//         Scanner s1 = new Scanner (System.in);
//         ArmstrongChecker checker = new ArmstrongChecker();
//         System.out.println("Enter the number:\t");
//         int num = s1.nextInt();
//         int count = 0, og_num = num;
//         while(num>0){
//             count++;
//             num /=10;
//         }
//         System.out.println("Number of digits = "+count);
//         if(checker.checkArmstrong(og_num, count)) {
//             System.out.println("Yes, the given number is an Armstrong Number");
//         }
//         else{
//             System.out.println("No, the given number is not an Armstrong Number");
//         }

//         s1.close();
        
        
        
        
//     }
// }

// class ArmstrongChecker{
//     boolean checkArmstrong(int num, int count){
//         int last_digit = 0, sum = 0, og_num = num;
//         for(int i = 0; i<count; i++){
//             last_digit = num%10;
//             num /=10;
//             sum += (int)Math.pow(last_digit, count);

//         }

//         if (sum == og_num) {
//             return true;
//         }
//         else{
//              return false;
//         }
//     }
// }


//Version 4 
import java.util.*;
class Armstrong{
    public static void main(String [] args){
        Scanner s1 = new Scanner (System.in);
        System.out.println("Enter the number:\t");
        int num = s1.nextInt();
        int count = 0, og_num = num;
        while(num>0){
            count++;
            num /=10;
        }
        System.out.println("Number of digits = "+count);
        if(ArmstrongChecker.checkArmstrong(og_num, count)) {
            System.out.println("Yes, the given number is an Armstrong Number");
        }
        else{
            System.out.println("No, the given number is not an Armstrong Number");
        }

        s1.close();
        
        
        
        
    }
}

class ArmstrongChecker{
    public static boolean checkArmstrong(int num, int count){
        int last_digit = 0, sum = 0, og_num = num;
        for(int i = 0; i<count; i++){
            last_digit = num%10;
            num /=10;
            sum += (int)Math.pow(last_digit, count);

        }

        if (sum == og_num) {
            return true;
        }
        else{
             return false;
        }
    }
}
