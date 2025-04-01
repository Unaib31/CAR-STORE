package CarStore.com;

public class Customer {
    private String name;
    private String phone;
    private String email;

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}
