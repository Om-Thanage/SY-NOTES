
// Java Program to Sort Names in an Alphabetical Order
import java.util.*;
 class strsort {
    public static void main(String[] args)
    {
       
        int n;
       Scanner s=new Scanner(System.in);
      System.out.println("Enter total no");
      n=s.nextInt();
        String names[]=new String[n];
      for (int i = 0; i < n; i++) 
      {
         System.out.println("Enter string at:"+(i+1));
          names[i]=s.next();
       }
         String temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) 
             {
                if (names[i].compareToIgnoreCase(names[j]) > 0) 
                {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.println(
            "The names in alphabetical order are: ");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }
    }
}
