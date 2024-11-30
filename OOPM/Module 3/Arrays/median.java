import java.util.*;

class median
{
   public static void main(String args[])
   {
     int n,i;
     Scanner s=new Scanner(System.in);
     
     System.out.println("Enter total number of elements");
     n=s.nextInt();
     int arr[]=new int[n];
     for(i=0;i<arr.length;i++)
     {
      System.out.println("value at:"+(i+1));
      arr[i]=s.nextInt();
     }
    
  System.out.println("The array is:");
for(i=0;i<n;i++)
     {
      System.out.println(+arr[i]);
     }
}
}



