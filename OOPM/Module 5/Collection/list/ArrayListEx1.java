
// Java program to demonstrate working of ArrayList in Java 
import java.io.*; 
import java.util.*; 
  
class ArrayListEx1
{ 
    public static void main(String[] args) 
                       throws IOException 
    { 
        // size of ArrayList 
        int n = 5; 
  
        //declaring ArrayList with initial size n 
        ArrayList<Integer> arrli = new ArrayList<Integer>(n); 
            
           for (int i=1; i<=n; i++) 
            arrli.add(i); 
  
        System.out.println(arrli);
        arrli.remove(3); 
 
        System.out.println(arrli); 
  
        for (int i=0; i<arrli.size(); i++) 
            System.out.print(arrli.get(i)+" "); 
    } 
} 