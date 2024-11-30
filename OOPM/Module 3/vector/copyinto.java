import java.io.*;
import java.util.*;
class copyinto
{
	public static void main(String args[])
	{
		Vector v= new Vector(3,2);
		int len=args.length;
		for(int i=0;i<len;i++)
		{
			v.addElement(args[i]);
		}
		int size=v.size();
		String str[]= new String[size];
		v.copyInto(str);
		for(int i=0;i<size;i++)
		{
			System.out.println ("Element of Vector at position "+i+": "+str[i]);
		}
	}
}

