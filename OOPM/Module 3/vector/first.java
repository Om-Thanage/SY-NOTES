
import java.util.*;
public class first {

   public static void main(String args[]) {
      
      Vector v = new Vector();
      
      v.add("Sunday");
      v.add("Monday");
      v.add("Tuesday");
      v.add("Wednesday");
      v.add("Thursday");
     v.add("Friday");
      v.add("Saturday");
    
      Enumeration days= v.elements();
      while (days.hasMoreElements()) 
     {
         System.out.println(days.nextElement()); 
      }
 
   }
}