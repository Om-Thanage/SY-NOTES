import java.util.*;

// Base class for Equipment
class Equipment {
    public String name;
    public String model;
    public int quantity;

    public Equipment(String name, String model, int quantity) {
        this.name = name;
        this.model = model;
        this.quantity = quantity;
    }

    public String toString() {
        return "Name: " + name + ", Model: " + model + ", Quantity: " + quantity;
    }
}

class HeavyEquipment extends Equipment {
    public HeavyEquipment(String name, String model, int quantity) {
        super(name, model, quantity);
    }
}

class LightEquipment extends Equipment {
    public LightEquipment(String name, String model, int quantity) {
        super(name, model, quantity);
    }
}

public class q2 {
    public static void main(String[] args) {
        // Vector to store Equipment objects
        Vector<Equipment> equipmentList = new Vector<Equipment>();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add new equipment");
            System.out.println("2. Remove equipment");
            System.out.println("3. Display equipment list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEquipment(scanner, equipmentList);
                    break;
                case 2:
                    removeEquipment(scanner, equipmentList);
                    break;
                case 3:
                    displaySortedEquipment(equipmentList);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    
    public static void addEquipment(Scanner scanner, Vector<Equipment> equipmentList) {
        try {
            System.out.print("Enter equipment type (1 for Heavy, 2 for Light): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter equipment name: ");
            String name = scanner.nextLine();

            System.out.print("Enter equipment model: ");
            String model = scanner.nextLine();

            System.out.print("Enter equipment quantity: ");
            int quantity = scanner.nextInt();

            if (type == 1) {
                equipmentList.add(new HeavyEquipment(name, model, quantity));
                System.out.println("Heavy equipment added successfully.");
            } else if (type == 2) {
                equipmentList.add(new LightEquipment(name, model, quantity));
                System.out.println("Light equipment added successfully.");
            } else {
                System.out.println("Invalid equipment type.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data types.");
            scanner.nextLine(); // Clear the invalid4
        }
    }

    // Method to display sorted equipment list
    public static void displaySortedEquipment(Vector<Equipment> equipmentList) {
        if (equipmentList.isEmpty()) {
            System.out.println("No equipment in the list.");
            return;
        }

        equipmentList.sort(Comparator.comparing(e -> e.name.toLowerCase())); // Sort by name
        System.out.println("\nSorted Equipment List:");
        for (Equipment eq : equipmentList) {
            System.out.println(eq);
        }
    }

    // Method to remove equipment by name based on user input
    public static void removeEquipment(Scanner scanner, Vector<Equipment> equipmentList) {
        System.out.print("Enter the name of the equipment to remove: ");
        String name = scanner.nextLine();

        boolean removed = equipmentList.removeIf(e -> e.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Equipment '" + name + "' removed successfully.");
        } else {
            System.out.println("Equipment with name '" + name + "' not found.");
        }
    }
}
