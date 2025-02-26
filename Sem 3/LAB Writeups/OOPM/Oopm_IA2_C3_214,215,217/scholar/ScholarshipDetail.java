package scholar;

public class ScholarshipDetail {
    private String name;
    private String description;
    private double amount;
    private double gpaRequirement;

    public ScholarshipDetail(String name, String description, double amount, double gpaRequirement) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.gpaRequirement = gpaRequirement;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public double getGpaRequirement() {
        return gpaRequirement;
    }

    public String toString() {
        return "Scholarship Name: " + name + "\nDescription: " + description +
               "\nAmount: Rs." + amount + "\nGPA Requirement: " + gpaRequirement + "\n";
    }
}
