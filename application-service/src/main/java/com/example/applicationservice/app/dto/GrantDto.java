package com.example.applicationservice.app.dto;

public class GrantDto {
    private String id;
    private String title;
    private double amount;
    private String category;

    public GrantDto() {
    }

    public GrantDto(String id, String title, double amount, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
