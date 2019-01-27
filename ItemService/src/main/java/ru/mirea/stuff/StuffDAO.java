package ru.mirea.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import ru.mirea.Item;
import ru.mirea.item.ItemRowMapper;
import ru.mirea.Stuff;

@Component
public class StuffDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StuffDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stuff> findAll() {
        return jdbcTemplate.query("select * from Stuff", new StuffRowMapper());
    }

    public List<Stuff> findStuffByID(int id) {
        return jdbcTemplate.query("select * from Stuff where internalID = " + id, new StuffRowMapper());
    }

    public List<Item> findThePriceOfStuff(int id) {
        return jdbcTemplate.query("select id, name, price, count from Stuff where internalID = " + id, new ItemRowMapper());
    }


}
