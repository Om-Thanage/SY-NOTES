import java.util.*;

public class bvector1
{
public static void main(String[] args)
{
Vector l = new Vector(5,1);
Vector v;

for(int i=0;i<args.length;i=i+3)
{
v = new Vector(3,3);
v.addElement(args[i]);
v.addElement(args[i+1]);
v.addElement(args[i+2]);

l.addElement(v);

}
Enumeration en = l.elements();
while(en.hasMoreElements())
{
System.out.println(en.nextElement());

}

}
}
