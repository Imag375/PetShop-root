package ru.mirea.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO){
        this.itemDAO = itemDAO;
    }

    public void subItem(int id) {
        itemDAO.minusCount(id);
    }

    public void addItem(int id) {
        itemDAO.plusCount(id);
    }
}
