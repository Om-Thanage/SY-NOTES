import java.io.*;
class stgbufr
{
    public static void main (String[] args)
    {
        StringBuffer s=new StringBuffer("GeeksforGeeks");
        s.delete(0,5);
        System.out.println(s); 
        s.deleteCharAt(7);
        System.out.println(s); 
    }
}
