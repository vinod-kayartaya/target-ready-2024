package com.targetindia.model;

public class Book {
    public int id;
    public String title;
    public double price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';

    }
}
