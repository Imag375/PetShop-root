package ru.mirea.stuff;

import org.springframework.jdbc.core.RowMapper;
import ru.mirea.Stuff;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

class StuffRowMapper implements RowMapper<Stuff> {

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
