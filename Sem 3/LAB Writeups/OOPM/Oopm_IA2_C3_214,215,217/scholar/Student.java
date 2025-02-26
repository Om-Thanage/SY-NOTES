package scholar;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private String email;
    private String major;
    private double gpa;
    private int year;
    private List<ScholarshipDetail> appliedScholarships;

    public Student(int studentID, String name, String email, String major, double gpa, int year) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
        this.appliedScholarships = new ArrayList<>();
    }

    public void applyForScholarship(ScholarshipDetail scholarship, ScholarshipManager scholarshipManager) {
        appliedScholarships.add(scholarship);
        scholarshipManager.applyForScholarship(this, scholarship);
    }

    public List<ScholarshipDetail> getAppliedScholarships() {
        return appliedScholarships;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }
    

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }
}
