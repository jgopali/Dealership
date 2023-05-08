package Main;

import java.sql.*;

public class CheckInv {

    public static void printInventory() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbops.dbconn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM dealer");

            while (resultSet.next()) {
                String carMake = resultSet.getString("Make");
                String carModel = resultSet.getString("Model");
                int quantity = resultSet.getInt("Quantity");
                double price = resultSet.getDouble("Price");
                System.out.println(carMake + " " + carModel + "; there are " + quantity + " and it costs " + price);
            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
