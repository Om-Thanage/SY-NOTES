import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class BufferedReaderDemo {
 
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D://newfile.txt");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while (s != null) 
       {
            System.out.println(s);
            s = br.readLine();
        }
        br.close();
    }
}