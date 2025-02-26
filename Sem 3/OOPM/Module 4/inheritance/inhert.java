import java.util.*;
class Room
{
     int l,b;
     Room(int x,int y)
     {
         l=x;
         b=y;
      }
int area()
{  return(l*b);}
}
class Bedroom extends Room
{
  int h;
  Bedroom(int x,int y,int z)
  {
    super(x,y);
     h=z;
   }
int volume()
{
   return(l*b*h);
}
}
public class inhert 
{
 public static void main(String args[]) 
{
    Bedroom r1=new Bedroom(14,12,13);
    int area1=r1.area();
    int vol1=r1.volume();
    System.out.println("Area="+area1);
     System.out.println("Volume="+vol1);
}
}

     
 