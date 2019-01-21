package ru.mirea.stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;
import ru.mirea.DataService;
import ru.mirea.domain.Stuff;

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

    public List<Stuff> findThePriceOfStuff(int id) {
        return jdbcTemplate.query("select id, name, price from Stuff " +
                "where internalID = " + id, new StuffRowMapper());
    }

    private class StuffRowMapper implements RowMapper<Stuff> {

        //@Override
        public Stuff mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String info = resultSet.getString("info");
            BigDecimal price = resultSet.getBigDecimal("price");
            int count = resultSet.getInt("count");
            int internalID = resultSet.getInt("internalID");

            return new Stuff(id, name, info, price, count, internalID);
        }
    }
}
