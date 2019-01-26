package ru.mirea;

import java.math.BigDecimal;

public class CartItem {

    protected int userID;
    protected int internalID;
    protected int itemID;
    protected String name;
    protected BigDecimal price;
    protected int count;

    public int getUserID() {
        return userID;
    }

    public int getInternalID() {
        return internalID;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public CartItem(int userID, int internalID, int itemID, String name, BigDecimal price, int count) {
        this.userID = userID;
        this.internalID = internalID;
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.count = count;
    }
}