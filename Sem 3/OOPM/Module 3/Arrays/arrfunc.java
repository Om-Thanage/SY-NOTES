import java.util.*;
class arrfunc
{
   public static void main(String args[])
   {
     int n,i;
     Scanner s=new Scanner(System.in);
     
     System.out.println("Enter total number of students");
     n=s.nextInt();
     int arr[]=new int[n];
     for(i=0;i<arr.length;i++)
     {
      System.out.println("value at:"+(i+1));
      arr[i]=s.nextInt();
     }
     asort(arr,n);
   
     }
 public static void asort(int arr[],int n)
   {
      int i,j;
      for(i=0;i<n-1;i++)
      {
       for(j=i+1;j<n;j++)
       {
         if(a[i]>a[j])
         {
           int t=a[i];
           a[i]=a[j];
           a[j]=t;
          }
      }
     }
  System.out.println("The sorted array is:");
for(i=0;i<n;i++)
     {
      System.out.println(+arr[i]);
     }
}
}



