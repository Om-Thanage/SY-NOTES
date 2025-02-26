import java.util.*;
class Student
 {
      public int roll_no;
      public String name;
      public double avg_mark;
Student(int roll_no,String name,double avg_mark)
              {
	this.roll_no=roll_no;
	this.name=name;
	this.avg_mark=avg_mark;
	}
}

public class StArObj
{
 public static void main (String[] args)
{      Scanner obj=new Scanner(System.in);
        System.out.println("Enter total no of students");
        int n= obj.nextInt();
       Student[] arr=new Student[n];
       String str,item,n1,tr,a;
       int j,len,choice,pos,r;
		
			
while(true)
          {
               System.out.println("\n\nChoose your choice ...");
               System.out.println("1) Add Student Detail");
               System.out.println("2) Delete student detail ");
               System.out.println("3) Display Student detail");
               System.out.println("4) Exit");
              
               System.out.print("Enter your choice : ");
               
               try{
				  
                  choice=obj.nextInt();
      
                   switch(choice)
                   {
                       case 1 :    System.out.print("Enter no: of student details you want to add : ");
                                           
                                        len=obj.nextInt(); 
										
                                        for (int i=0; i < len; i++)
		        {
			System.out.println("Enter the name of student "+i+":");
			n1= obj.readLine();
											
			System.out.println("Enter roll no student "+i+":");
			r= obj.nextInt();
											
			System.out.println("Enter roll no student "+i+":");
			a= Double.parseDouble(obj.readLine());
											
			arr[i]=new Student(r,n1,a);

		     }
                                        break;
                      case 2 :     System.out.print("Enter the position  Student details to be Deleted : ");
                                        System.out.flush();
                                        tr=obj.readLine();
                                        pos=Integer.parseInt(tr);
                                        for(int i=pos-1;i< arr.length-1;i++)
		          arr[i] = arr[i + 1];
		        arr[arr.length - 1] = null;
                                        break;
                      case 3 :     System.out.print("The items of array are ");
                                        for (int i=0;i<arr.length;i++)
		  System.out.println("Student "+i+" : "+arr[i].roll_no+" "+ arr[i].name+" "+ arr[i].avg_mark);
                                        break;
                     case 4 :         System.out.println("\n\nThank You for using this software.....");
                                        System.exit(1);
                                        break;
                      default :     System.out.println("\nEntered Choice is Invalid\nTry Again\n");
                    }
                }
            catch(Exception e) {}
         }      

	
  }
}
