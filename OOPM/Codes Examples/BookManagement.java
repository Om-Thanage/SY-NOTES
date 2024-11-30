/*Write a java program using array of Objects for Book Management 
1. Add Book
2. Delete Book
3. Sort By Price
4. DisplayAllBooks

 */
import java.util.*;

class Book{
	private String name;
	private String title;
	private String author;
	private double price;

	Book(String name, String title, String author, double price){
		this.name = name;
		this.title = title;
 		this.author = author;
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}
	
	public static void addBook(Book [] books, int n){
		for(int i = 0; i<n; i++){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the book");
		String name = sc.nextLine();
		System.out.println("Enter the author of the book");
		String author = sc.nextLine();
		System.out.println("Enter the title of the book");
		String title = sc.nextLine();
		System.out.println("Enter the price of book");
		double price = sc.nextDouble();
		books[i] = new Book(name, title, author, price);
		System.out.println("Book added successfully");
		}
	}
	
	public static void deleteBook(Book [] books){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of Book to be deleted");
		String search = sc.nextLine();
		for(int i = 0; i<books.length; i++){
			if( books[i] != null && books[i].getName().equals(search)){ //Add Null Checking
				for(int j = i; j<books.length; j++){
					books[j] = books[j+1];
				}
				books[books.length - 1] = null; 
				System.out.println("Book deleted successfully");
				return;
			}		
			
		}
		System.out.println("Book Not Found");
	}

	public static void sortByPrice( Book [] books){
		for(int i = 0; i<books.length - 1; i++){
			for(int j = i + 1; j<books.length; j++){
				if(books[i] != null && books[j] != null && (books[i].getPrice()>books[j].getPrice())){ //Add null checking
					Book temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}
			}
		}
	}

	public static void displayAllBooks( Book [] books){
		for(Book i: books){
			System.out.println(i.getName());
			System.out.println(i.getPrice());
		}
	}	
}


public class BookManagement{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Books");
		int n = sc.nextInt();
		Book [] books = new Book[n];
		Book.addBook(books, n);
		Book.deleteBook(books);
		Book.displayAllBooks(books);
		Book.sortByPrice(books);
		Book.displayAllBooks(books);
	}
}