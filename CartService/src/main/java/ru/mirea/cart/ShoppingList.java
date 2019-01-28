package ru.mirea.cart;

import ru.mirea.CartItem;
import ru.mirea.price.TotalPrice;

import java.util.List;

public class ShoppingList {

    protected List<CartItem> shoppingList;
    protected TotalPrice totalPrice;

    public List<CartItem> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<CartItem> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ShoppingList(List<CartItem> shoppingList, TotalPrice totalPrice) {
        this.shoppingList = shoppingList;
        this.totalPrice = totalPrice;
    }
}
