package Main;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to login: ");
        String password = scanner.nextLine();

        if (password.equals("password")) {
            System.out.println("Login successful!");
            Dealership.showroomfloor();
        } else {
            System.out.println("Invalid password. Access denied.");
        }
    }
}
