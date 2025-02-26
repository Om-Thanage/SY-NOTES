
class Room
{ 
    float length;
    float breadth;
   Room(float x, float y)
   {
       length=x;
       breadth=y;
  }
  Room()
  {
   length=breadth=0;
  }
  Room(float x)
  {
   length=breadth=x;
  }
  float area()
 {
   return(length*breadth);
  }
}
 class constructor_overloading
{
   public static void main(String args[])
   {
      Room r1=new Room(15,20);
       Room r2=new Room(15);
       Room r3= new Room();
     System.out.println("Area of rectangular room:"+r1.area());
    System.out.println("Area of Square room:"+r2.area());
        System.out.println("Area of Square room:"+r3.area());
    }
}