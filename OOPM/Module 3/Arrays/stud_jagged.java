import java.util.*;
class stud_jagged
{
   public static void main(String args[])
   {
     int n,i,j,m;
     Scanner s=new Scanner(System.in);
     System.out.println("Enter total number of students");
     n=s.nextInt();
     int arr[][]=new int[n][];
     for(i=0;i<n;i++)
     {
      System.out.println("Enter no of semesters for student:"+(i+1));
      m=s.nextInt();
      arr[i]=new int[m];
      for(j=0;j<m;j++)
      {
         System.out.println("Enter the marks for student:"+(i+1)+"in semester:"+(j+1));
          arr[i][j]=s.nextInt();
      }
    
      }
}
}



