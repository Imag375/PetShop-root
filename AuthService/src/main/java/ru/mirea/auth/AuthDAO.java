package ru.mirea.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.mirea.User;

public class AuthDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public User getUserByLogin(String userLogin){
        return jdbcTemplate.queryForObject("select * from User where login = '" + userLogin + "'", new AuthRowMapper());
    }
}
