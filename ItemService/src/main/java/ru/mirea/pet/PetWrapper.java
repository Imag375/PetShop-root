package ru.mirea.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ru.mirea.Pet;

import java.math.BigDecimal;

public class PetWrapper {

    public int getId(){
        return id;
    }

    public int getCount(){
        return count;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public int getInternalID(){
        return internalID;
    }

    private int id;
    private int count;
    private BigDecimal price;
    @JsonIgnore
    private int internalID;

    PetWrapper(Pet tmp){
        this.id = tmp.getId();
        this.count = tmp.getCount();
        this.price = tmp.getPrice();
        this.internalID = tmp.getInternalID();
    }
}
