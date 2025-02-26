import java.util.*;
import java.io.*;
class bvector
{
	public static void main(String args[])
	{
		Vector v2 = new Vector(10);
		int i=0;
		while(i<args.length)
		{
			Vector v1=new Vector(3);
			v1.add(args[i]);
			i++;
			v1.add(args[i]);
			i++;
			v1.add(args[i]);
			i++;
			v2.add(v1);
		}
		Scanner sc=new Scanner(System.in);
		int temp=0;
		while(temp!=5)
		{
		System.out.println("MAIN MENU");
		System.out.println("1.Delete Item, 2.Add at end, 3.Add at location, 4. Display, 5.Exit");
		temp=sc.nextInt();
		switch(temp)
		{
			case 1:
			System.out.println("Enter item to delete");
			Vector t=new Vector();
			String item=sc.next();
			for(int k=0;k<v2.size();k++)
			{
				t=(Vector) v2.get(k);
				if(item.equals(t.get(0)))
					v2.remove(t);
			}
			System.out.println("Element deleted");
			break;
			
			case 2:
			System.out.println("Enter item, price and ID");
			String item1=sc.next();
			int price1=sc.nextInt();
			int id1=sc.nextInt();
			Vector v3=new Vector(10);
			v3.addElement(item1);
			v3.addElement(price1);
			v3.addElement(id1);
			v2.add(v3);
			System.out.println("Element added");
			break;
			
			case 3:
			System.out.println("Enter item, price and ID");
			String item2=sc.next();
			int price2=sc.nextInt();
			int id2=sc.nextInt();
			System.out.println("Enter location");
			int loc=sc.nextInt();
			Vector v4=new Vector(10);
			v4.addElement(item2);
			v4.addElement(price2);
			v4.addElement(id2);
			v2.add(loc,v4);
			System.out.println("Element added at "+loc);
			break;
			
			case 4:
			Enumeration en=v2.elements();
			while(en.hasMoreElements())
				System.out.println(en.nextElement()+" ");
			break;
			
			case 5:
			break;
			
			default:
			System.out.println("Invalid Input");
			break;
		
		}
		}
	}
}