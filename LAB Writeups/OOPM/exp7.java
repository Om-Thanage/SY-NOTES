import java.util.*;

class NumberException extends Exception{
    //Using Super class constructor
    // NumberException(){
    //     super("The number contains digit 3");
    // }
   
    public String toString(){
        return "The number contains digit 3";
    }
}

public class exp7{
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        sc.close();
        try{
            while(n>0){
                int last_digit = n%10;
                n /= 10;
                if(last_digit == 3){
                    throw new NumberException();
                }
            }
            System.out.println("The number does not contain 3");
        }

        catch(NumberException e){
            System.out.println(e.toString());
        }

        


    }


}
