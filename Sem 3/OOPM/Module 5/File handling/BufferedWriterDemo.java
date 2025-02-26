import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class BufferedWriterDemo {
 
    public static void main(String[] args) throws IOException {
        File f = new File("one.txt");
        
if(!f.exists()){
    	   f.createNewFile();}
System.out.println(f.exists());
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(97);
        bw.newLine();
        char[] ch1 = { 'a', 'b', 'c', 'd' };
        bw.write(ch1);
        bw.newLine();
        bw.write("TECH");
      
        bw.newLine();
        bw.write("software");
       bw.newLine();
bw.write("This is demo for writing contents to a file");
bw.write("I have modified the contents of this file");
        bw.flush();
        bw.close();
    }
}