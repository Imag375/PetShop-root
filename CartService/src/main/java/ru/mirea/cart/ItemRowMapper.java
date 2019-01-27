package ru.mirea.cart;

import org.springframework.jdbc.core.RowMapper;
import ru.mirea.CartItem;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<CartItem> {

    public CartItem mapRow(ResultSet resultSet, int i) throws SQLException {
        int userID = resultSet.getInt("userID");
        int itemID = resultSet.getInt("itemID");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        int count = resultSet.getInt("count");

        return new CartItem(userID, itemID, name, price, count);
    }
}