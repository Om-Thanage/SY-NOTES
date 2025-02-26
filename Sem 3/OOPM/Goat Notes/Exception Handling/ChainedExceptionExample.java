class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

class DataAccessLayer {
    public void connectToDatabase() throws DatabaseConnectionException {
        try {
            // Simulate a low-level exception (SQLException)
            throw new SQLException("Unable to connect to the database.");
        } catch (SQLException e) {
            // Chain the original exception (SQLException) with a higher-level exception
            throw new DatabaseConnectionException("Failed to connect to database in DataAccessLayer.", e);
        }
    }
}

public class ChainedExceptionExample {
    public static void main(String[] args) {
        try {
            DataAccessLayer dal = new DataAccessLayer();
            dal.connectToDatabase();
        } catch (DatabaseConnectionException e) {
            // Print the custom exception and its cause
            System.out.println("Caught: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause());
        }
    }
}
