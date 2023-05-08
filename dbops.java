package Main;

import java.sql.*;

public class dbops {

    public static Connection dbconn() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership", "root", "Hulk22ge!");
        return connection;
    }
}
