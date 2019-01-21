package mirea.domain;

import java.util.ArrayList;
import java.util.List;

public class Balance {

    public static List<Item> shoppingList = new ArrayList<Item>();

    public static void addToCart(Item item) {

        if(item.count > 0) {
            shoppingList.add(item);
            item.count--;
        }
    }

    public static void deleteFromCart(int id){

        if((id >= 0) && (id <= shoppingList.size())){
            Item item = shoppingList.get(id);
            item.count++;
            shoppingList.remove(id);
        }
    }
}