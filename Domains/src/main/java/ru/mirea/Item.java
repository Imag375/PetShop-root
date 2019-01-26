package ru.mirea;

import java.math.BigDecimal;

public class Item {
    protected int id;
    protected String name;
    protected BigDecimal price;
    protected int count;

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
