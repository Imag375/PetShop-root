package ru.mirea.item;

import org.springframework.jdbc.core.RowMapper;
import ru.mirea.Item;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {

    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        int count = resultSet.getInt("count");

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setCount(count);

        return item;
    }
}