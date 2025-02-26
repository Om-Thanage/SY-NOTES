import java.util.*;
 
public class sortfunction
{
    public static void main(String[] args)
    {
       
        Vector<Integer> al = new Vector<Integer>();
        al.add(1);
        al.add(2);
        al.add(-2);
        al.add(0);
        al.add(3);

        Collections.sort(al);

        System.out.println("Vector after the use of" +
                           " Collection.sort() :\n" + al);
  Collections.sort(al, Collections.reverseOrder());
System.out.println("Vector after the use of reverse order" +
                           " Collection.sort() :\n" + al);
    }
}