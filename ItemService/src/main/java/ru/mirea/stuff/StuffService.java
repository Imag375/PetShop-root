package ru.mirea.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import java.util.List;

import org.springframework.stereotype.Service;
import ru.mirea.Item;
import ru.mirea.Stuff;

@Service
public class StuffService {

    private StuffDAO stuffDAO;

    @Autowired
    public StuffService(StuffDAO stuffDAO){
        this.stuffDAO = stuffDAO;
    }

    @Nullable
    public List<Stuff> findAll() {
        return stuffDAO.findAll();
    }

    @Nullable
    public List<Stuff> findStuffByID(int id) {
        return stuffDAO.findStuffByID(id);
    }

    @Nullable
    public List<Item> findThePriceOfStuff(int id) {
        return stuffDAO.findThePriceOfStuff(id);
    }
}