package ru.mirea;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class Pet extends Item {

    public String getInfo(){
        return info;
    }

    public int getInternalID() {
        return internalID;
    }

    String info;
    @JsonIgnore
    int internalID;

    public Pet(int id, String name, String info, BigDecimal price, int count, int internalID){
        this.id = id;
        this.name = name;
        this.info = info;
        this.price = price;
        this.count = count;
        this.internalID = internalID;
    }

    public Pet(){

    }
}
