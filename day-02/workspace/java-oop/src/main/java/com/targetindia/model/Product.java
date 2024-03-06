package com.targetindia.model;

public class Product {
    private int id;
    private String name;
    private double price;

    // best practice
    public Product() {
    }

    // overloaded / parameterized constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Invalid value for id. Must be >= 0.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name != null) {
            name = name.trim(); // "    asdf  "  --> "asdf" or "     " --> ""
            if (name.length() < 3 || name.length() > 50) {
                throw new RuntimeException("Length of name must be between 3 and 50 letters.");
            }
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new RuntimeException("Invalid value for price. Must be >= 0.");
        }
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
