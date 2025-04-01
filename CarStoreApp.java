package CarStore.com;
import java.util.Scanner;

public class CarStoreApp {
    private static final String ADMIN_USERNAME = "Unaib";
    private static final String ADMIN_PASSWORD = "unaib123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarStore carStore = new CarStore();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Car Store Menu ---");
            System.out.println("1. View Cars");
            System.out.println("2. Filter Cars by Budget");
            System.out.println("3. Book a Car");
            System.out.println("4. Book a Test Drive");
            System.out.println("5. Add Review");
            System.out.println("6. View Cars by Brand");
            System.out.println("7. Admin Login");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> carStore.displayCars();
                case 2 -> {
                    System.out.print("Enter min budget: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter max budget: ");
                    double maxPrice = scanner.nextDouble();
                    carStore.filterCarsByBudget(minPrice, maxPrice);
                }
                case 3 -> {
                    System.out.print("Enter model to book: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    carStore.bookCar(model, name, phone, email);
                }
                case 4 -> {
                    System.out.print("Enter model to book a test drive: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    carStore.bookTestDrive(model, name);
                }
                case 5 -> {
                    System.out.print("Enter model to add review: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter your review: ");
                    String review = scanner.nextLine();
                    carStore.addReview(model, review);
                }
                case 6 -> carStore.displayCarsByBrand();
                case 7 -> adminPanel(carStore, scanner);
                case 8 -> {
                    running = false;
                    System.out.println("Exiting the Car Store.");
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }

    private static void adminPanel(CarStore carStore, Scanner scanner) {
        System.out.print("\nEnter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("\n✅ Admin Login Successful!");
            boolean adminRunning = true;

            while (adminRunning) {
                System.out.println("\n--- Admin Panel ---");
                System.out.println("1. Add Car");
                System.out.println("2. Remove Car");
                System.out.println("3. View All Cars");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");

                int adminChoice = scanner.nextInt();
                scanner.nextLine();

                switch (adminChoice) {
                    case 1 -> {
                        System.out.print("Enter Model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Fuel Type (Petrol/Diesel): ");
                        String fuelType = scanner.nextLine();
                        carStore.addCar(model, brand, price, fuelType);
                    }
                    case 2 -> {
                        System.out.print("Enter Model to Remove: ");
                        String model = scanner.nextLine();
                        carStore.removeCar(model);
                    }
                    case 3 -> carStore.displayCars();
                    case 4 -> adminRunning = false;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("❌ Invalid Admin Credentials!");
        }
    }
}
