import java.util.*; 
class Rectangle 
{ 
     int l,w;
     Rectangle(int x,int y)
     {
        l=x;
        w=y;
     }
  void  rectArea()
   {
    System.out.println("Area="+(l*w));
  }
}
class withconstructor
{
public static void main(String[] args) 
   {  
      Scanner s=new Scanner(System.in);

      int area1,area2,a,b;
      System.out.println("Enter length and with of the first rectangle");
      a=s.nextInt();
      b=s.nextInt();
      Rectangle rect1=new Rectangle(a,b);
      System.out.println("Enter length and with of the second rectangle");
      a=s.nextInt();
      b=s.nextInt();
      Rectangle rect2=new Rectangle(a,b);
      area1=rect1.rectArea();
      area2=rect2.rectArea();
    System.out.println("Area 1="+area1);
    System.out.println("Area 2="+area2);
   }
}

  
   