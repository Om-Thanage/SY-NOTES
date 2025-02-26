import java.util.*;

class Student {
    String name;
    Long roll;
    double percentage;

    Student(String name, Long roll, double percentage) {
        this.name = name;
        this.roll = roll;
        this.percentage = percentage;
    }
}

public class StudentRecord {
    Vector<Student> v1 = new Vector<>(4, 2);
    Scanner sc = new Scanner(System.in);

    public void Sort() {
        Collections.sort(v1, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.percentage, s1.percentage);
            }
        });
    }

    public void SortbyRoll() {
        Collections.sort(v1, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Long.compare(s2.roll, s1.roll); // Sort by roll number in descending order
            }
        });
    }
    

    public void create() {
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of the student:");
            String name = sc.nextLine();  // Read the full name
            System.out.println("Enter the roll number of the student:");
            Long roll = sc.nextLong();
            System.out.println("Enter the percentage obtained by the student:");
            double percentage = sc.nextDouble();
            sc.nextLine(); // Consume newline

            Student std = new Student(name, roll, percentage);
            v1.add(std);
        }
        Sort();
    }

    public void insert() {
        System.out.println("Enter the name of the student:");
        String name = sc.nextLine();  // Read the full name
        System.out.println("Enter the roll number of the student:");
        Long roll = sc.nextLong();
        System.out.println("Enter the percentage obtained by the student:");
        double percentage = sc.nextDouble();
        sc.nextLine(); // Consume newline

        Student std = new Student(name, roll, percentage);
        v1.add(std);
        Sort();
    }

    public void deleteByName() {
        System.out.println("Enter the name of the student:");
        String name = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).name.equals(name)) {
                v1.remove(i);
                found = true;
                System.out.println("Student record deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void deleteByRoll() {
        System.out.println("Enter the roll number of the student:");
        Long roll = sc.nextLong();
        boolean found = false;

        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).roll.equals(roll)) {
                v1.remove(i);
                found = true;
                System.out.println("Student record deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void display() {
        if (v1.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            System.out.println("Students List:");
            for (Student e : v1) {
                System.out.println("Name: " + e.name + " | Roll: " + e.roll + " | Percentage: " + e.percentage);
            }
        }
    }

    

    public static void main(String[] args) {
        System.out.println("Welcome to Student Record Manager");
        StudentRecord sr = new StudentRecord();
        sr.create();
        sr.display();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1: Add student");
            System.out.println("2: Delete by name");
            System.out.println("3: Delete by roll number");
            System.out.println("4: Display Students List");
            System.out.println("5: Exit");
            System.out.println("Enter your choice:");
            int choice = sr.sc.nextInt();
            sr.sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    sr.insert();
                    break;
                case 2:
                    sr.deleteByName();
                    break;
                case 3:
                    sr.deleteByRoll();
                    break;
                case 4:
                    sr.display();
                    break;
                case 5:
                    System.out.println("Thank you for using this app");
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a correct option.");
            }
        }
    }
}
