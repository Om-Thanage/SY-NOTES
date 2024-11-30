/* WAP to accept n no of customers from users.Create an array of objects to store account_id and name.
Your program should provide following functionalities
1.To add account
2.To delete any account detail
3.To display account detail.
*/
import java.util.Scanner;
class Arrayobjects
{
   public static void main(String args[])
{   
     Scanner s=new Scanner(System.in);
      int n,pos,choice,len,p;
      String r;
      System.out.println("Enter total no of account holders");
      p=s.nextInt();
     Account arr[] = new Account[p] ;
    while(true)
          {
               System.out.println("\n\nChoose your choice ...");
               System.out.println("1) Add Account Detail");
               System.out.println("2) Delete Account detail ");
               System.out.println("3) Display Account detail");
               System.out.print("Enter your choice : ");
              choice=s.nextInt();

              switch(choice)
                   {
                       case 1 :    System.out.print("Enter no: of account details you want to add : ");
                                           len=s.nextInt(); 
			for (int i=0; i < len; i++)
		        {
			System.out.println("Enter the id of the  Account holder");
			n= s.nextInt();						
			System.out.println("Enter name of the account holder ");
			r= s.next();
			arr[i]=new Account(n,r); }
                                        break;
                      case 2 :     System.out.print("Enter the position  of account holder to be Deleted : ");
                                        pos=s.nextInt();
                                        for(int i=pos-1;i< arr.length-1;i++)
		          arr[i] = arr[i + 1];
		        arr[arr.length - 1] = null;
                                        break;
                      case 3 :     System.out.print("The items of array are ");
                                     
                                        for (int i=0;i<arr.length;i++)
                                        { if(arr[i]!=null)
		  System.out.println("Account holder "+i+" : "+arr[i].account_id+" "+ arr[i].name);}
                                        break;
                     
                      default :     System.out.println("\nEntered Choice is Invalid\nTry Again\n");
                    }
    }
  }
}
 class Account
{
 public int account_id;
 public String name;
 Account(int c,String d)
{
   account_id=c;
   name=d;
 }

}