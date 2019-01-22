package mirea.domain;

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

}
