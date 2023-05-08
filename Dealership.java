package Main;

import java.sql.SQLException;
import java.util.*;

public class Dealership {

    public static void showroomfloor() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("Welcome to the dealership!");
            System.out.println("1. Buy a car");
            System.out.println("2. See the inventory");
            System.out.println("3. Add to inventory");
            System.out.println("4. Add a new car");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    Buy.buycar();
                    break;
                case 2:
                    CheckInv.printInventory();
                    break;
                case 3:
                    addinv.addInventory();
                    break;
                case 4:
                    NewCar.addNewCar();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
