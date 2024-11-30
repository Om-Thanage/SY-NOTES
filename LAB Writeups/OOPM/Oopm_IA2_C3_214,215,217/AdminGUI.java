import javax.swing.*;
import java.awt.*;
import scholar.ScholarshipManager;
import scholar.Student;
import scholar.ScholarshipDetail;
import java.util.List;

public class AdminGUI {
    private ScholarshipManager scholarshipManager;

    public AdminGUI(ScholarshipManager scholarshipManager) {
        this.scholarshipManager = scholarshipManager;
        showLoginForm();
    }

    private void showLoginForm() {
        JFrame loginFrame = new JFrame("Admin Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(new GridBagLayout());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null); // Centering the frame

        
        loginFrame.getContentPane().setBackground(new Color(240, 248, 255));

        
        JLabel nameLabel = new JLabel("Username:");
        JTextField nameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);

        
        loginButton.addActionListener(e -> {
            String username = nameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("password123")) {
                loginFrame.dispose();
                showAdminInterface();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials, please try again.");
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginFrame.add(nameLabel, gbc);

        gbc.gridx = 1;
        loginFrame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginFrame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginFrame.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        loginFrame.add(loginButton, gbc);

        loginFrame.setVisible(true);
    }

    private void showAdminInterface() {
        JFrame adminFrame = new JFrame("Admin Interface");
        adminFrame.setSize(400, 400);
        adminFrame.setLayout(new GridLayout(6, 2));
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLocationRelativeTo(null); // Centering the frame

        
        adminFrame.getContentPane().setBackground(new Color(188, 227, 227));

        JLabel nameLabel = new JLabel("Scholarship Name:");
        JTextField nameField = new JTextField();
        JLabel descLabel = new JLabel("Description:");
        JTextField descField = new JTextField();
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel gpaLabel = new JLabel("GPA Requirement:");
        JTextField gpaField = new JTextField();
        JButton addButton = new JButton("Add Scholarship");
        JButton viewAppsButton = new JButton("View Student Applications");

        addButton.setBackground(new Color(70, 130, 180));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        
        viewAppsButton.setBackground(new Color(70, 130, 180));
        viewAppsButton.setForeground(Color.WHITE);
        viewAppsButton.setFocusPainted(false);
        viewAppsButton.setBorderPainted(false);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String description = descField.getText();
            double amount;
            double gpaRequirement;

            try {
                amount = Double.parseDouble(amountField.getText());
                gpaRequirement = Double.parseDouble(gpaField.getText());

                ScholarshipDetail newScholarship = new ScholarshipDetail(name, description, amount, gpaRequirement);
                scholarshipManager.addScholarship(newScholarship);
                JOptionPane.showMessageDialog(adminFrame, "Scholarship added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(adminFrame, "Please enter valid numeric values for Amount and GPA Requirement.");
            }
        });

        viewAppsButton.addActionListener(e -> showStudentApplications());

        adminFrame.add(nameLabel);
        adminFrame.add(nameField);
        adminFrame.add(descLabel);
        adminFrame.add(descField);
        adminFrame.add(amountLabel);
        adminFrame.add(amountField);
        adminFrame.add(gpaLabel);
        adminFrame.add(gpaField);
        adminFrame.add(addButton);
        adminFrame.add(viewAppsButton);
        adminFrame.setVisible(true);
    }

    private void showStudentApplications() {
        JFrame applicationsFrame = new JFrame("Student Applications");
        applicationsFrame.setSize(400, 300);
        applicationsFrame.setLocationRelativeTo(null); // Centering the frame

        JTextArea applicationsArea = new JTextArea();
        applicationsArea.setEditable(false);
        
        applicationsArea.append("Student Applications:\n\n");

        for (ScholarshipDetail scholarship : scholarshipManager.getScholarships()) {
            applicationsArea.append("Applications for " + scholarship.getName() + ":\n");
            List<Student> applicants = scholarshipManager.getStudentsForScholarship(scholarship);
            
            if (applicants.isEmpty()) {
                applicationsArea.append("  No applications yet.\n");
            } else {
                for (Student student : applicants) {
                    applicationsArea.append("  - " + student.getName() + "\n" +
                            "    Email: " + student.getEmail() + "\n" +
                            "    Major: " + student.getMajor() + "\n" +
                            "    GPA: " + student.getGpa() + "\n" +
                            "    Year: " + student.getYear() + "\n\n");
                }
            }
            applicationsArea.append("\n");
        }

        applicationsFrame.add(new JScrollPane(applicationsArea), BorderLayout.CENTER);
        applicationsFrame.setVisible(true);
    }
}
