package ru.mirea.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.mirea.DataService;
import ru.mirea.domain.Pet;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<Pet> findThePriceOfPet(int id) {
        return jdbcTemplate.query("select id, name, price from Pet " +
                "where internalID = " + id, new PetRowMapper());
    }

    private class PetRowMapper implements RowMapper<Pet> {

        //@Override
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
}
