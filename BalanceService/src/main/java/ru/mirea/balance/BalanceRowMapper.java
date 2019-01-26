package ru.mirea.balance;

import org.springframework.jdbc.core.RowMapper;

import ru.mirea.Balance;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceRowMapper implements RowMapper<Balance> {

    @Override
    public Balance mapRow(ResultSet resultSet, int i) throws SQLException {
        int userID = resultSet.getInt("userID");
        BigDecimal money = resultSet.getBigDecimal("money");
        return new Balance(userID, money);
    }
}
