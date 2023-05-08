package Main;

import java.sql.*;
import java.util.*;
public class addinv {

   public static void addInventory() {
    try {
        // Connect to the database
        Connection connection = dbops.dbconn();

        // Prompt the user for the model and quantity to add
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the model you want to add inventory for: ");
        String model = scanner.nextLine();
        System.out.print("Enter the quantity to add: ");
        int quantityToAdd = scanner.nextInt();

        // Prepare the SQL statement
        String sql = "UPDATE dealer SET Quantity = Quantity + ? WHERE Model = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quantityToAdd);
        statement.setString(2, model);

        // Execute the SQL statement and print the number of rows affected
        int rowsAffected = statement.executeUpdate();
        System.out.println(rowsAffected + " rows updated.");

        // Close the resources
        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        System.err.println("Error updating inventory: " + e.getMessage());
    }
}


}
