import java.util.*;

class Item {
    private String name;
    private double price;
    private int discount;
    private double finalPrice;

    public String getname() {
        return name;
    }

    public double getprice() {
        return price;
    }

    public int getdiscount() {
        return discount;
    }

    public double getfinalPrice() {
        return finalPrice;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public void setdiscount(int discount) {
        this.discount = discount;
    }

    public void setfinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    Item(String name, double price, int discount, double finalPrice) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }
}

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Item> Product = new Vector<Item>();

        System.out.println("Welcome To ShopManager");
        additems(Product);

        System.out.println("1. Add multiple discount");
        System.out.println("2. Show Final Price");
        System.out.println("3. Search Product");
        System.out.println("4. Exit");

        int choice;
        while (true) {
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter the product name to apply discount:");
                    String name = sc.nextLine();
                    boolean foundDiscount = false;
                    for (int i = 0; i < Product.size(); i++) {
                        if (Product.get(i).getname().equals(name)) {
                            foundDiscount = true;
                            System.out.println("Product Found");
                            System.out.println("Enter discount to apply in %:");
                            int discount = sc.nextInt();
                            double price = Product.get(i).getprice();
                            double finalPrice = price - ((price * discount) / 100);
                            int totaldiscount = Product.get(i).getdiscount() + discount;
                            // Check if total discount exceeds 100%
                            if (totaldiscount > 100) {
                                System.out.println("Total discount cannot exceed 100%");
                            } else {
                                Product.get(i).setdiscount(totaldiscount);
                                Product.get(i).setfinalPrice(finalPrice);
                            }
                            break;
                        }
                    }
                    if (!foundDiscount) {
                        System.out.println("Product not found");
                    }
                    break;

                case 2:
                    System.out.println("Enter the product name to display Final Price:");
                    String searchname = sc.nextLine();
                    boolean foundFinalPrice = false;
                    for (int i = 0; i < Product.size(); i++) {
                        if (Product.get(i).getname().equals(searchname)) {
                            foundFinalPrice = true;
                            System.out.println("Final Price: " + Product.get(i).getfinalPrice());
                            break;
                        }
                    }
                    if (!foundFinalPrice) {
                        System.out.println("Product not found");
                    }
                    break;

                case 3:
                    System.out.println("Enter the product name to search:");
                    String search4details = sc.nextLine();
                    boolean foundDetails = false;
                    for (int i = 0; i < Product.size(); i++) {
                        if (Product.get(i).getname().equals(search4details)) {
                            foundDetails = true;
                            System.out.println("Name: " + Product.get(i).getname());
                            System.out.println("Price: " + Product.get(i).getprice());
                            System.out.println("Discount: " + Product.get(i).getdiscount());
                            System.out.println("Final Price: " + Product.get(i).getfinalPrice());
                            break;
                        }
                    }
                    if (!foundDetails) {
                        System.out.println("Product not found");
                    }
                    break;

                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        }
        sc.close(); // Close the scanner
    }

    public static void additems(Vector<Item> Product) {
        System.out.println("Enter the number of products to be added:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of Product:");
            String name = sc.nextLine();
            System.out.println("Enter the price:");
            double price = sc.nextDouble();
            System.out.println("Enter the discount on Product:");
            int discount = sc.nextInt();
            double finalPrice = price - ((discount * price) / 100);
            Product.add(new Item(name, price, discount, finalPrice));
            System.out.println("Product added successfully");
            sc.nextLine(); // Consume the newline for the next iteration
        }
        sc.close();
    }
}

