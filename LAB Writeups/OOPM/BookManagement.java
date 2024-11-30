import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;
    private String isbn;

    // Constructor
    Book(String title, String author, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }



    public static void addBook(Book[] books) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the book:");
        String title = sc.nextLine();
        System.out.println("Enter the author of the book:");
        String author = sc.nextLine();
        System.out.println("Enter the price of the book:");
        double price = sc.nextDouble();
        System.out.println("Enter the ISBN of the book:");
        String isbn = sc.next();
        
        
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = new Book(title, author, price, isbn);
                System.out.println("Book added successfully!");
                return;
            }
        }
        System.out.println("No space available to add a new book.");
    }

    
    public static void deleteBook(Book[] books) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ISBN of the book to be deleted:");
        String isbn = sc.next();

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[books.length - 1] = null;
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public static void displayallBooks(Book[] books) {
        boolean isEmpty = true;
        for (Book book : books) {
            if (book != null) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println();
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("No books available.");
        }
    }

    public static void SortbyPrice(Book books[]) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if (books[i] != null && books[j] != null && books[i].getPrice() > books[j].getPrice()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
    


}

public class BookManagement {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[10];
        int choice;

        while (true) {
            System.out.println("Choose your option ...");
            System.out.println("1) Add Books");
            System.out.println("2) Delete Book");
            System.out.println("3) Display all Books");
            System.out.println("4) Sort by Price");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of books you want to add:");
                    int numBooks = sc.nextInt();
                    for (int i = 0; i < numBooks; i++) {
                        System.out.println("Adding book " + (i + 1));
                        System.out.println("---------------------------------------------------");
                        Book.addBook(books);
                        System.out.println();
                    }
                    break;
                case 2:
                    Book.deleteBook(books);
                    break;
                case 3:
                    Book.displayallBooks(books);
                    break;
                case 4:
                    Book.SortbyPrice(books);
                    Book.displayallBooks(books);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
