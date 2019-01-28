package ru.mirea.price;

import java.math.BigDecimal;

public class TotalPrice {

    protected BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public TotalPrice(BigDecimal price) {
        this.totalPrice = price;
    }
}
