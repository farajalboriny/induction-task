package com.progressoft.induction;


public class Snack {
    private int quantity;
    private SnackType type;

    public Snack(int quantity, SnackType type) {
        this.quantity = quantity;
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SnackType getType() {
        return type;
    }

    public int quantity() {
        return this.quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }
}
