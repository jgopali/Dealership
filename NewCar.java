package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewCar {

    public static void addNewCar() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        // Get user input for new car details
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter mileage: ");
        double mileage = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // Connect to the database
        Connection connection = dbops.dbconn();

        // Create a prepared statement with parameter placeholders for the new car details
        String sql = "INSERT INTO dealer (Make, Year, Model, Mileage, Price, Quantity) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, make);
        statement.setInt(2, year);
        statement.setString(3, model);
        statement.setDouble(4, mileage);
        statement.setDouble(5, price);
        statement.setInt(6, quantity);

        // Execute the prepared statement to insert the new car row into the database
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("New car added successfully.");
        } else {
            System.out.println("Failed to add new car.");
        }

        // Close the database connection
        connection.close();
    }
}
