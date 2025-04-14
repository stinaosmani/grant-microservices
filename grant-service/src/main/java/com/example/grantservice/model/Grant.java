package com.example.grantservice.model;

public class Grant {
    private String id;
    private String title;
    private double amount;
    private String category;

    public Grant() {
    }

    public Grant(String id, String title, double amount, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
