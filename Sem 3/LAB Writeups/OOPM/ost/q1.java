import java.util.Scanner;
import employeePackage.EmployeeOperations;
import employeePackage.Employee;

public class q1 {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management");
        
        Scanner sc = new Scanner(System.in);
        EmployeeOperations empop = new EmployeeOperations();

        
        boolean flag = true;
        while (flag) {
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Update");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = sc.next();
                    System.out.print("Enter Employee ID: ");
                    Long id = sc.nextLong();
                    System.out.print("Enter Employee Department: ");
                    String department = sc.next();
                    System.out.print("Enter Employee Salary: ");
                    Long salary = sc.nextLong();
                    
                    Employee newEmployee = new Employee(name, id, department, salary);
                    empop.addEmp(newEmployee);
                    break;

                case 2: // Remove
                    System.out.print("Enter Employee ID to remove: ");
                    Long removeId = sc.nextLong();
                    empop.removeEmp(removeId);
                    break;

                case 3: // Update
                    System.out.print("Enter Employee ID to update salary: ");
                    Long updateId = sc.nextLong();
                    System.out.print("Enter new salary: ");
                    Long newSalary = sc.nextLong();
                    empop.updateSalary(updateId, newSalary);
                    break;

                case 4:
                    empop.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        sc.close();
    }
}
