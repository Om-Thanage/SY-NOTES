import java.io.FileWriter; 
import java.io.IOException; 
class writeFW
{ 
    public static void main(String[] args) throws IOException 
    { 
        
        String str = "File Handling in Java using "+ 
                " FileWriter and FileReader"; 
  
       
        FileWriter fw=new FileWriter("output.txt"); 
  
       
        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 
         fw.write("A");
        System.out.println("Writing successful"); 
     
        fw.close(); 
    } 
}