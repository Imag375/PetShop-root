package ru.mirea.pet;

import org.springframework.jdbc.core.RowMapper;

import ru.mirea.Pet;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

class PetRowMapper implements RowMapper<Pet> {

    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String info = resultSet.getString("info");
        BigDecimal price = resultSet.getBigDecimal("price");
        int count = resultSet.getInt("count");
        int internalID = resultSet.getInt("internalID");

        return new Pet(id, name, info, price, count, internalID);
    }
}