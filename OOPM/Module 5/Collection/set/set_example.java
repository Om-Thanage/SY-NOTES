
import java.util.*; 
public class set_example 
{ 
    public static void main(String[] args) 
    { 
      
        Set<String> s = new HashSet<String>(); 
        s.add("abc"); 
        s.add("For"); 
        s.add("Abc"); 
        s.add("Example"); 
        s.add("Set"); 
        System.out.print("Set output without the duplicates"); 
  
        System.out.println(s); 
  
        // Set deonstration using TreeSet 
        System.out.print("Sorted Set after passing into TreeSet"); 
        Set<String> tree_Set = new TreeSet<String>(s); 
        System.out.println(tree_Set); 
    } 
} 