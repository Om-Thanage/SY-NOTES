import java.util.ArrayList;
 
public class CFG {
    public static void main(String[] args)
    {
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add("Hello");
        arr.add(14);
        arr.add(1800L);
        arr.add(6.0D);
        arr.add(1.99F);
 System.out.print("ArrayList after all insertions: ");
        display(arr);
        arr.set(0, 50);
        arr.set(1, 10.0D);
        System.out.print("ArrayList after modifications: ");
        display(arr);
    }
    public static void display(ArrayList<Object> arr)
    {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}