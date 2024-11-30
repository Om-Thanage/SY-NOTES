package scholar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScholarshipManager {
    private List<ScholarshipDetail> scholarships;
    private List<Student> students;
    private Map<ScholarshipDetail, List<Student>> scholarshipApplications;


    public ScholarshipManager() {
        scholarships = new ArrayList<>();
        students = new ArrayList<>();
        scholarshipApplications = new HashMap<>();
    }

    public void addScholarship(ScholarshipDetail scholarship) {
        scholarships.add(scholarship);
        scholarshipApplications.put(scholarship, new ArrayList<>());
    }

    public List<ScholarshipDetail> getScholarships() {
        return scholarships;
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public boolean studentExists(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void applyForScholarship(Student student, ScholarshipDetail scholarship) {
        if (scholarshipApplications.containsKey(scholarship)) {
            scholarshipApplications.get(scholarship).add(student);
        }
    }

    public List<Student> getStudentsForScholarship(ScholarshipDetail scholarship) {
        return scholarshipApplications.getOrDefault(scholarship, new ArrayList<>());
    }
}
