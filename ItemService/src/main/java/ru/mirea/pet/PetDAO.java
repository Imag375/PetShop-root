package ru.mirea.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import ru.mirea.Item;
import ru.mirea.ItemRowMapper;
import ru.mirea.Pet;

@Component
public class PetDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> findAll() {
        return jdbcTemplate.query("select * from Pet;", new PetRowMapper());
    }

    public List<Pet> findPetByID(int id) {
        return jdbcTemplate.query("select * from Pet where internalID = " + id, new PetRowMapper());
    }

    public List<Item> findThePriceOfPet(int id) {
        return jdbcTemplate.query("select id, name, price, count from Pet where internalID = " + id, new ItemRowMapper());
    }
}
