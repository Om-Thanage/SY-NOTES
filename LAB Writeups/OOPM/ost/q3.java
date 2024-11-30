import java.util.*;

interface Sports {
    float sportWt = 6.0F;

    void putWt();
}

class Student {
    public Long rollNo;

    Student(Long rollNo) {
        this.rollNo = rollNo;
    }
}

class Test extends Student {
    public int test1;
    public int test2;

    Test(Long rollNo, int test1, int test2) {
        super(rollNo);
        this.test1 = test1;
        this.test2 = test2;
    }
}

class Result extends Test implements Sports {
    public int totalMarks;

    Result(Long rollNo, int test1, int test2) {
        super(rollNo, test1, test2);
        totalMarks = test1 + test2;
    }

    @Override
    public void putWt() {
        System.out.println("Sports Weight: " + sportWt);
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Test 1 Marks: " + test1);
        System.out.println("Test 2 Marks: " + test2);
        System.out.println("Total Marks (without sports): " + totalMarks);
        System.out.println("Total Marks (with sports): " + (totalMarks + sportWt));
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter roll number: ");
        Long rollNo = scanner.nextLong();
        System.out.println("Enter marks for test 1: ");
        int test1 = scanner.nextInt();
        System.out.println("Enter marks for test 2: ");
        int test2 = scanner.nextInt();

        Result result = new Result(rollNo, test1, test2);

        result.putWt();
        result.display();

        scanner.close();
    }
}
