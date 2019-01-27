package ru.mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DataService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        /*String sql ="CREATE TABLE User(" +
                "userID int(36) NOT NULL, " +
                "login varchar(255) NOT NULL, " +
                "password varchar(255) NOT NULL, " +
                "role varchar(10) NOT NULL," +
                "PRIMARY KEY(userID));";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO User VALUES" +
                "('3', 'user1', '1234', 'user')," +
                "('4', 'user2', '1234', 'admin');";
        jdbcTemplate.execute(sql);*/
    }
}
