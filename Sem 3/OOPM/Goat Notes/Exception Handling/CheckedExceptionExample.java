import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            // This method might throw a checked exception (IOException)
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("Caught a checked exception: " + e.getMessage());
        }
    }

    // Declaring the checked exception
    public static void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);

        // Reading the first line
        System.out.println(fileInput.readLine());
        fileInput.close();
    }
}
