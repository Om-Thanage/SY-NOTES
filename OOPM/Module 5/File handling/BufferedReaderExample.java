import java.io.*;

class BufferedReaderExample

{

       public static void main(String args[]) throws IOException

       {

            String s="This program is skipping first character of each word in the string";

            StringReader sr=new StringReader(s);

            System.out.println("The input string is: "+s);

            /*Creating an instance of BufferedReader using StringReader*/

            BufferedReader br=new BufferedReader(sr);

            //Reading from the underlying StringReader

            System.out.print ("The output string is: ");

            br.skip(1); /*skipping the first character of the first word of the input string*/

            //reading the remaining string

            int i=0;

            while((i=br.read()) !=-1)

                   {

                      System.out.print((char)i);

                      if((char)i==' ') //checking for white spaces

                        {

                              br.skip(1); /*skipping first character of each word*/

                        }

                  }

          }

}