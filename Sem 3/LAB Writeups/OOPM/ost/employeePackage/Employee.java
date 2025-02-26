package employeePackage;

public class Employee {
    private String name;
    private Long id;
    private String department;
    private Long salary;

    public Employee(String name, Long id, String department, Long salary){
        this.name= name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }


    //Getters
    public String getname(){
        return name;
    }

    public Long getid(){
        return id;
    }

    public String getDepartment(){
        return department;
    }

    public Long getSalary(){
        return salary;
    }

    //Setters
    public void setname(String name){
        this.name = name;
    }

    public void setid(Long id){
        this.id = id;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(Long salary){
        this.salary = salary;
    }
}

