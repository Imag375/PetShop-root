package ru.mirea.price;

import java.math.BigDecimal;

public class TotalPrice {
    protected int userID;
    protected BigDecimal price;

    public int getUserID() {
        return userID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TotalPrice(int userID, BigDecimal price) {
        this.userID = userID;
        this.price = price;
    }
}
