
class ehandle2
{
  
  public static void main(String args[])throws Exception
  { 
     int a=10,b=5,c=5;
    try
   {
    int x=a/(b-c);
     System.out.println("x="+x);
  }
 catch(ArrayIndexOutOfBoundsException e)
       {
   System.out.println("Array index error");
       }
catch(ArithmeticException e)
  {   
   System.out.println("Division by zero:" +e);
   }
   int y=a/(b+c);
   System.out.println("y="+y);
     
    }
}