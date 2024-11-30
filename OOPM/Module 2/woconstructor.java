 class Rectangle 
{ 
  int l,w;
     void getData(int x, int y)
     {  
       l=x;
       w=y;
      }
  int rectArea()
   {
    int area=l*w;
    return(area);
  }
}
class woconstructor
{
public static void main(String[] args) 
   {  
      int area1,area2;
      Rectangle rect1=new Rectangle();
      Rectangle rect2=new Rectangle();
      rect1.l=15;
      rect1.w=10;
      area1=rect1.l * rect1.w;
      rect2.getData(20,12);
      area2=rect2.rectArea();
      System.out.println("Area 1= "+area1);
     System.out.println("Area 2= "+area2);
   }
}

  
   