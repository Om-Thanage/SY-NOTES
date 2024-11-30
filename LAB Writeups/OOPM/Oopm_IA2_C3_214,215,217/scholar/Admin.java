package scholar;
import java.util.List;
 


public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void addScholarship(List<ScholarshipDetail> scholarships, String name, String description, double amount, double gpaRequirement) {
        scholarships.add(new ScholarshipDetail(name, description, amount, gpaRequirement));
        System.out.println("Scholarship added successfully.");
    }

    public String toString() {
        return "Admin Username: " + username;
    }
}
