import java.util.*;

class Leap{
  public static void main(String [] args){
    Scanner s1 = new Scanner (System.in);
    System.out.println("Enter the year:\t");
    int year = s1.nextInt();
    if(checkLeap(year)){
      System.out.println("Yes, it is a leap year");
    }
    else{
      System.out.println("No, it is not a leap year");
    }
    s1.close();
  }
  static boolean checkLeap(int year){
    if(year%4 == 0){
      if(year%100 == 0){
        if(year%400 == 0){
          return true;
        }
        else{
          return false;
        }
      }
      else{
        return true;
      }
    }
    else{
      return false;
    }
  }
}