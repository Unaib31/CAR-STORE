package CarStore.com;

import java.util.*;

public class CarStore {
    private List<Car> cars;

    public CarStore() {
        cars = new ArrayList<>();
        addSampleCars();  // Adding sample cars
    }

    private void addSampleCars() {
        cars.add(new Car("Swift", "Maruti", 600000, "Petrol"));
        cars.add(new Car("Nexon", "Tata", 800000, "Diesel"));
        cars.add(new Car("Thar", "Mahindra", 1300000, "Diesel"));
        cars.add(new Car("Creta", "Hyundai", 1200000, "Petrol"));
        cars.add(new Car("Innova", "Toyota", 2000000, "Diesel"));
    }

    // Method to display all cars
    public void displayCars() {
        System.out.println("\n🚗 Available Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // Method to display cars by brand with availability count
    public void displayCarsByBrand() {
        Map<String, Map<String, Integer>> brandCarCount = new HashMap<>();
        for (Car car : cars) {
            brandCarCount.computeIfAbsent(car.getBrand(), k -> new HashMap<>());
            Map<String, Integer> modelCount = brandCarCount.get(car.getBrand());
            modelCount.put(car.getModel(), modelCount.getOrDefault(car.getModel(), 0) + (car.isAvailable() ? 1 : 0));
        }

        System.out.println("\n🚗 Cars Categorized by Brand with Availability:");
        for (Map.Entry<String, Map<String, Integer>> entry : brandCarCount.entrySet()) {
            System.out.println("\n🔹 " + entry.getKey() + " Cars:");
            for (Map.Entry<String, Integer> modelEntry : entry.getValue().entrySet()) {
                System.out.println("   - " + modelEntry.getKey() + " | Available: " + modelEntry.getValue());
            }
        }
    }

    // Method to filter cars by budget
    public void filterCarsByBudget(double minPrice, double maxPrice) {
        boolean found = false;
        System.out.println("\n💰 Cars within budget ₹" + minPrice + " - ₹" + maxPrice + ":");
        for (Car car : cars) {
            if (car.getPrice() >= minPrice && car.getPrice() <= maxPrice && car.isAvailable()) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No cars found within this budget.");
        }
    }

    // Method to book a car
    public void bookCar(String model, String customerName, String phone, String email) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                car.bookCar(customerName);  // Calls bookCar method of Car class
                System.out.println("📜 Booking Details:");
                System.out.println("Customer: " + customerName);
                System.out.println("Phone: " + phone);
                System.out.println("Email: " + email);
                return;
            }
        }
        System.out.println("❌ Car not available or incorrect model name.");
    }

    // Method to book a test drive
    public void bookTestDrive(String model, String customerName) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                car.bookTestDrive(customerName); // Calls bookTestDrive method of Car class
                return;
            }
        }
        System.out.println("❌ Car not available or incorrect model name.");
    }

    // Method to add a review for a car
    public void addReview(String model, String review) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                car.addReview(review); // Calls addReview method of Car class
                return;
            }
        }
        System.out.println("❌ Car not found for review.");
    }

    // Method to add a new car to the inventory
    public void addCar(String model, String brand, double price, String fuelType) {
        cars.add(new Car(model, brand, price, fuelType));
        System.out.println("✅ Car added successfully!");
    }

    // Method to remove a car from the inventory
    public void removeCar(String model) {
        cars.removeIf(car -> car.getModel().equalsIgnoreCase(model));
        System.out.println("🚗 Car removed from inventory.");
    }
}
