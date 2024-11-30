import java.io.*;

class BufferedWriterExample

{

      public static void main(String args[]) throws IOException

      {   

          String s="This is an example of BufferedWriter";

          StringWriter sw=new StringWriter();

          //creating an instance of BufferedWriter class

          BufferedWriter bw=new BufferedWriter(sw);

          bw.write(s,0,5);

          bw.newLine();

          bw.write(s,5,s.length()-5); /*writes the substring starting from index 5*/

          bw.flush() ; //flushes the stream

          System.out.println(sw.getBuffer());

          sw.close(); //closing the stream

          bw.close(); //closing the stream

       }

}