import java.util.*;
class sup
{
     int x;
     sup(int x)
     {
         this.x=x;
      }
void display()
{  System.out.println("Super class x="+x);}
}
class sub extends sup
{
  int y;
  sub(int x,int y)
  {
    super(x);
     this.y=y;
   }
//void display()
//{  System.out.println("Super class x="+x);
//System.out.println("Sub class y="+y);}
}
class moverride
{
 public static void main(String args[]) 
{
    sub s1=new sub(100,200);
    s1.display();
}
}

     
 