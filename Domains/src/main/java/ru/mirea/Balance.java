package ru.mirea;

import java.math.BigDecimal;

public class Balance {

    private int userID;
    private BigDecimal money;

    public int getUserID() {
        return userID;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Balance(int userID, BigDecimal money) {
        this.userID = userID;
        this.money = money;
    }

    public Balance(){

    }
}