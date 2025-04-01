package CarStore.com;

public class Car {
    private String model;
    private String brand;
    private double price;
    private String fuelType;
    private boolean available;
    private String bookedBy; // Stores customer name when booked
    private String review; // Stores review for the car
    private boolean testDriveBooked;

    public Car(String model, String brand, double price, String fuelType) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.fuelType = fuelType;
        this.available = true;
        this.bookedBy = null;
        this.review = "";
        this.testDriveBooked = false;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public String getReview() {
        return review;
    }

    public boolean isTestDriveBooked() {
        return testDriveBooked;
    }

    // Method to book the car
    public void bookCar(String customerName) {
        if (available) {
            available = false;
            bookedBy = customerName;
            System.out.println("✅ Car " + model + " has been booked successfully by " + customerName + ".");
        } else {
            System.out.println("❌ Car " + model + " is already booked.");
        }
    }

    // Method to book a test drive
    public void bookTestDrive(String customerName) {
        if (!testDriveBooked) {
            testDriveBooked = true;
            System.out.println("✅ Test drive for " + model + " has been booked successfully by " + customerName + ".");
        } else {
            System.out.println("❌ Test drive for " + model + " is already booked.");
        }
    }

    // Method to add a review for the car
    public void addReview(String review) {
        this.review = review;
        System.out.println("✅ Review for " + model + " has been added: " + review);
    }

    @Override
    public String toString() {
        return brand + " " + model + " | ₹" + price + " | Fuel: " + fuelType + " | Available: " + (available ? "Yes" : "No") + " | Review: " + review;
    }
}
