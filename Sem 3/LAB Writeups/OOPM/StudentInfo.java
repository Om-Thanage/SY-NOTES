import java.util.*;
public class StudentInfo {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = sc.nextInt();

        Student[] stud = new Student[n];

        for(int i = 0; i<n; i++){
            System.out.println("Enter details for student " + (i + 1));

            System.out.println("Enter the id: ");
            long id = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the average marks: ");
            double avgMarks = sc.nextDouble();

            stud[i] = new Student(id, name, avgMarks);
        }

        for( int i =0; i<n; i++){
            stud[i].displayStudent();
        }

        System.out.println("Enter the student id to be deleted");
        long id = sc.nextLong();
        sc.nextLine();

        n = deleteId( stud, n, id);

        System.out.println("Enter th details of student to be added");

        System.out.println("Enter the id: ");
            long newid = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the average marks: ");
            double avgMarks = sc.nextDouble();

            stud[n] = new Student(newid, name, avgMarks);

            n++;
        sc.close();
    }

    public static int deleteId (Student [] stud, int n, long id){
        int index = -1;
        for(int i = 0; i<n; i++){
            if( stud[i].stud_id == id){
                index = i;
                break;
            }
        }
        if( index == -1){
            System.out.println("Id not found");
            return n;
        }
        for( int i = index; i<n-1; i++){
            stud[i] = stud[i+1];
        }
        return n - 1;
    }
    
}

class Student{
    long stud_id;
    String name;
    double avg_marks;

    Student(long stud_id, String name, double avg_marks){
        this.stud_id = stud_id;
        this.name = name;
        this.avg_marks = avg_marks;
    }

    public void displayStudent() {
        System.out.println("ID: " + stud_id);
        System.out.println("Name: " + name);
        System.out.println("Average Marks: " + avg_marks);
    }

    


}
