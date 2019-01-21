package ru.mirea.domain;

import java.math.BigDecimal;

public class Item {
    protected int id;
    protected int count;
    protected String type;
    protected BigDecimal price;

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
