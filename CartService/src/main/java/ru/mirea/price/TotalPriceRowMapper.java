package ru.mirea.price;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalPriceRowMapper implements RowMapper<TotalPrice> {

    public TotalPrice mapRow(ResultSet resultSet, int i) throws SQLException {
        BigDecimal price = resultSet.getBigDecimal("TotalPrice");

        return new TotalPrice(price);
    }
}
