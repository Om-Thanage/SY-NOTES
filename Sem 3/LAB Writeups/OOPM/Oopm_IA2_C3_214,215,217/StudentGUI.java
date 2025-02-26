import javax.swing.*;
import java.awt.*;
import java.util.List;
import scholar.ScholarshipManager;
import scholar.ScholarshipDetail;
import scholar.Student;

public class StudentGUI {
    private ScholarshipManager scholarshipManager;
    private Student student;

    public StudentGUI(ScholarshipManager scholarshipManager) {
        this.scholarshipManager = scholarshipManager;
        showLoginForm();
    }

    private void showLoginForm() {
        JFrame loginFrame = new JFrame("Student Registration/Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(new GridBagLayout());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String password = new String(passwordField.getPassword());

            if (password.equals("password123")) {
                if (scholarshipManager.studentExists(name)) {
                    student = scholarshipManager.getStudentByName(name);
                    loginFrame.dispose();
                    showDashboard();
                } else {
                    loginFrame.dispose();
                    showStudentDetailsForm(name);
                }
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

    private void showStudentDetailsForm(String name) {
        JFrame detailsFrame = new JFrame("Student Registration");
        detailsFrame.setSize(400, 300);
        detailsFrame.setLayout(new GridLayout(7, 2));
        detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailsFrame.setLocationRelativeTo(null);

        
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel majorLabel = new JLabel("Major:");
        JTextField majorField = new JTextField();
        JLabel gpaLabel = new JLabel("GPA:");
        JTextField gpaField = new JTextField();
        JLabel yearLabel = new JLabel("Graduation Year:");
        JTextField yearField = new JTextField();
        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(e -> {
            try {
                int studentID = Integer.parseInt(idField.getText());
                String email = emailField.getText();
                String major = majorField.getText();
                double gpa = Double.parseDouble(gpaField.getText());
                int year = Integer.parseInt(yearField.getText());

                student = new Student(studentID, name, email, major, gpa, year);
                scholarshipManager.registerStudent(student);
                detailsFrame.dispose();
                showDashboard();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(detailsFrame, "Please enter valid numeric values for ID, GPA, and Graduation Year.");
            }
        });

        detailsFrame.add(idLabel);
        detailsFrame.add(idField);
        detailsFrame.add(emailLabel);
        detailsFrame.add(emailField);
        detailsFrame.add(majorLabel);
        detailsFrame.add(majorField);
        detailsFrame.add(gpaLabel);
        detailsFrame.add(gpaField);
        detailsFrame.add(yearLabel);
        detailsFrame.add(yearField);
        detailsFrame.add(registerButton);

        detailsFrame.setVisible(true);
    }

    private void showDashboard() {
        JFrame dashboardFrame = new JFrame("Student Dashboard");
        dashboardFrame.setSize(400, 300);
        dashboardFrame.setLayout(new BorderLayout());
        dashboardFrame.setLocationRelativeTo(null);

        JPanel scholarshipPanel = new JPanel();
        scholarshipPanel.setLayout(new BoxLayout(scholarshipPanel, BoxLayout.Y_AXIS));
        updateScholarshipList(scholarshipPanel);

        JButton viewAppliedButton = new JButton("View Applied Scholarships");
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dashboardFrame.dispose();
            showLoginForm();
        });

        viewAppliedButton.addActionListener(e -> showAppliedScholarships());

        dashboardFrame.add(new JScrollPane(scholarshipPanel), BorderLayout.CENTER);
        dashboardFrame.add(viewAppliedButton, BorderLayout.SOUTH);
        dashboardFrame.add(logoutButton, BorderLayout.NORTH);

        dashboardFrame.setVisible(true);
    }

    private void updateScholarshipList(JPanel scholarshipPanel) {
        scholarshipPanel.removeAll();
        scholarshipPanel.add(new JLabel("Available Scholarships:"));
        List<ScholarshipDetail> availableScholarships = scholarshipManager.getScholarships();

        for (ScholarshipDetail scholarship : availableScholarships) {
            JPanel scholarshipEntryPanel = new JPanel();
            scholarshipEntryPanel.setLayout(new FlowLayout());

            JLabel scholarshipLabel = new JLabel(scholarship.toString());
            JButton applyButton = new JButton("Apply for " + scholarship.getName());
            applyButton.addActionListener(e -> applyForScholarship(scholarship));

            scholarshipEntryPanel.add(scholarshipLabel);
            scholarshipEntryPanel.add(applyButton);
            scholarshipPanel.add(scholarshipEntryPanel);
        }
        scholarshipPanel.revalidate();
        scholarshipPanel.repaint();
    }

    private void applyForScholarship(ScholarshipDetail scholarship) {
        if (student.getGpa() >= scholarship.getGpaRequirement()) {
            student.applyForScholarship(scholarship, scholarshipManager);
            JOptionPane.showMessageDialog(null, "Applied for " + scholarship.getName() + " successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "GPA requirement not met for " + scholarship.getName() + ".");
        }
    }

    private void showAppliedScholarships() {
        JFrame appliedFrame = new JFrame("Applied Scholarships");
        appliedFrame.setSize(400, 300);
        appliedFrame.setLocationRelativeTo(null);
        JTextArea appliedArea = new JTextArea();
        appliedArea.setEditable(false);
        
        appliedArea.append("Applied Scholarships:\n");
        for (ScholarshipDetail scholarship : student.getAppliedScholarships()) {
            appliedArea.append(scholarship.toString() + "\n");
        }

        appliedFrame.add(new JScrollPane(appliedArea), BorderLayout.CENTER);
        appliedFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ScholarshipManager scholarshipManager = new ScholarshipManager();
        new AdminGUI(scholarshipManager);
        new StudentGUI(scholarshipManager);
    }
}

