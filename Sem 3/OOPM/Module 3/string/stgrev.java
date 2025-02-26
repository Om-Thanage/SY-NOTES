import java.io.*;
import java.util.*;
class stgrev
{
    public static void main (String[] args)
    {
        String n, choice;
	Scanner s = new Scanner(System.in);
	System.out.println("Enter string:");
	n = s.nextLine();
	StringBuffer sb = new StringBuffer(n);	
	System.out.println("want to modify?(yes/no):");
	choice = s.nextLine();
	if(choice == "yes")
	{	
		String substring;
		int count=0;
		int len,i;
		String new_substring;
	 	System.out.println("Enter Substring:");
		substring=s.nextLine();
		new_substring=sb.append(substring);
		len=sb.length();
		for(i=0;i<=len-1;i++)
		{
			switch(sb.charAt(i))
			{
				case 'a':
					count++;
					break;
				case 'e':
					count++;
					break;
				case 'i':
					count++;
					break;
				case 'o':
					count++;
					break;
				case 'u':
					count++;
					break;
				default:
					break;
		 	
		
		
	}
    }
}
