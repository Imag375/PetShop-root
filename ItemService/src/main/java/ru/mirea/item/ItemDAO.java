package ru.mirea.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ItemDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void minusCount(int id) {
        jdbcTemplate.execute("update Item set count = count - 1 where id = " + id);
    }

    public void plusCount(int id) {
        jdbcTemplate.execute("update Item set count = count + 1 where id = " + id);
    }
}
