class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

public class EcommerceApp {
    public static void main(String[] args) {
        try {
            processOrder(0);
        } catch (OutOfStockException e) {
            System.out.println("Order error: " + e.getMessage());
        }
    }

    public static void processOrder(int stock) throws OutOfStockException {
        if (stock <= 0) {
            throw new OutOfStockException("The item is out of stock.");
        }
        System.out.println("Order processed successfully!");
    }
}
