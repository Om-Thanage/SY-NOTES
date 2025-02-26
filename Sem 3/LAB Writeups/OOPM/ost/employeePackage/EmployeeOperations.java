package employeePackage;

import java.util.*;

public class EmployeeOperations{

    private Vector <Employee> emp;

    public EmployeeOperations(){
        this.emp = new Vector<>();
    }

    public void addEmp(Employee employee) {
        emp.add(employee);
        System.out.println("Employee added successfully: " + employee.getname());
    }

    public void removeEmp(Long id){
        for(int i = 0; i<emp.size(); i++){
            if(emp.get(i).getid().equals(id)){
                emp.remove(i);
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void updateSalary(Long id, Long upsal) {
        for (Employee employee : emp) {
            if (employee.getid().equals(id)) {
                employee.setSalary(upsal);
                System.out.println("Updated salary for employee ID " + id + " to " + upsal);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void displayEmployees() {
        Collections.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getname().compareTo(e2.getname());
            }
        });
        
        for (Employee employee : emp) {
            System.out.println("ID: " + employee.getid() + ", Name: " + employee.getname() +
                               ", Department: " + employee.getDepartment() +
                               ", Salary: " + employee.getSalary());
        }
    }

    
}
