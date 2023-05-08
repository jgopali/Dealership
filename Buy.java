package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Buy {

    public static void buycar() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter car type to buy (or 'back' to go back):");
            String model = scanner.nextLine();

            if (model.equals("back")) {
                return; // exit the method and go back to the previous menu
            }

            System.out.println("Enter quantity to buy:");
            int quantity = scanner.nextInt();

            // Connect to the database
            Connection connection = dbops.dbconn();

            // Update the quantity of the selected car type
            String sql = "UPDATE dealer SET Quantity = Quantity - ? WHERE Model = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, quantity);
            statement.setString(2, model);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Purchase successful!");
            } else {
                System.out.println("Failed to complete purchase.");
            }
        }
    }
}
