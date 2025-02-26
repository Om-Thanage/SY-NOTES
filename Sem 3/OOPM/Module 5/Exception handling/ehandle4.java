import java.util.Scanner;
class MyException extends Exception
{
   public String toString()
{
    return "Age Not eligible for voting";
} 
}
class ehandle1
{
  public static void main(String args[])
  { 
    int n;
    Scanner s=new Scanner(System.in);
    MyException a= new MyException();
    System.out.println("Enter age");
    n=s.nextInt();
  try
  {
    if (n<18)
      throw a;
 }
  catch(MyException e)
{
System.out.println(e.toString());
}
}
}
