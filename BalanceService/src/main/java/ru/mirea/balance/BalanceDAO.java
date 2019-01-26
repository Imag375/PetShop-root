package ru.mirea.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mirea.Balance;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BalanceDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BalanceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Balance> getBalanceByUserID(int userID) {
        return jdbcTemplate.query("select * from Balance where userID =" + userID, new BalanceRowMapper());
    }

    public void updateUserBalance(BigDecimal newBalance, int userID) {
        jdbcTemplate.execute("update balance set money = " + newBalance + " where userID = " + userID);
    }
}
