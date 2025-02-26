import java.util.*;
class Employee
{
   int id;
   String name;
   float salary;
   Employee(int id, String name,float salary)
   {
    this.id=id;
    this.name=name;
    this.salary=salary;
    } 
}
class aob
{  
    public static void main(String args[])
    {
       int n,i,j;
       int x,pos;
            String s;
            float sal;
       Scanner s1= new Scanner(System.in);
       System.out.println("Enter total number of employees"); 
       n=s1.nextInt();
       Employee emp[]=new Employee[n];
       for(i=0;i<n;i++)
       {   
            
            System.out.println("Enter values employee id employee name and salary for Employee:"+(i+1));
             x=s1.nextInt();
             s=s1.nextLine();
             sal=s1.nextFloat();
             emp[i]=new Employee(x,s,sal);
         }
	



      for(i=0;i<n-1;i++)
       {
      for(j=i;j<n-1;j++)
        {
        if(emp[j].salary<emp[j+1].salary)
        {
             Employee t;
             t=emp[j];
            emp[j]=emp[j+1];
            emp[j+1]=t;
         }
      }
     }
               System.out.print("The employee records in sorted order are ");
                                     
                                        for (int i=0;i<emp.length;i++)
                                        { if(emp[i]!=null)
		  System.out.println("Employee "+i+" : "+emp[i].emp_id+" "+ emp[i].name+" "+ emp[i].salary);
                                       }

        
             System.out.print("Enter the position  of Employee to be Deleted : ");
                                        pos=s.nextInt();
                                        for(int i=pos-1;i< emp.length-1;i++)
                                        {
		                            emp[i] = emp[i + 1];
		                            emp[emp.length - 1] = null;
                                        }  
                                     
                       System.out.print("The employee records are ");
                                     
                                        for (int i=0;i<emp.length;i++)
                                        { if(emp[i]!=null)
		  System.out.println("Employee "+i+" : "+emp[i].emp_id+" "+ emp[i].name+" "+ emp[i].salary);
                                        }
    }
   }

                                        
     

            