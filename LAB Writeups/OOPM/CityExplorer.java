import java.util.*;

public class CityExplorer {
    public static void main(String[] args) {
        // Create a Vector to store city names
        Vector<String> cities = new Vector<>();
        Scanner s = new Scanner(System.in);
        
        // Adding cities to the Vector
        System.out.println("Enter number of cities to add:");
        int n = s.nextInt();
        s.nextLine(); // Consume the newline character
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter city name:");
            String city = s.nextLine();
            cities.add(city);  // Add city to the vector
        }
        
        // Removing a city
        System.out.println("Enter city name to remove:");
        String cityToRemove = s.nextLine();
        if (cities.remove(cityToRemove)) {
            System.out.println(cityToRemove + " has been removed.");
        } else {
            System.out.println(cityToRemove + " not found.");
        }

        // Print all cities
        System.out.println("All cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        Sort(cities);
        System.out.println("All cities:");
        for (String city : cities) {
            System.out.println(city);
        }




        s.close();
    }

    public static void Sort(Vector <String> cities){
        Collections.sort(cities);            
        System.out.println("Cities after sorting:");
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
