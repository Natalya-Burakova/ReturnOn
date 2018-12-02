package model;

import java.time.LocalDate;

public class Product {

    private String name;
    private Integer amount;
    private Float price;
    private LocalDate date;


    public Product(String name) {
        this.name = name;
    }

    public Product(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Product(String name, Integer amount, Float price, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public void setPrice(Float price) { this.price = price; }

    public void setDate(LocalDate date) { this.date = date; }

    public void setAmount(Integer amount) { this.amount = amount; }

    public String getName() { return name; }

    public LocalDate getDate() { return date; }

    public Float getPrice() { return price; }

    public Integer getAmount() { return amount; }


    @Override
    public String toString() {
        return this.getName() +" "+this.getPrice()+" "+this.getAmount()+" "+this.getDate();
    }
}
