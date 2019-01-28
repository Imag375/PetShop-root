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
        /*String sql ="CREATE TABLE Cart(" +
                "userID int(36) NOT NULL, " +
                "itemID int(36) NOT NULL, " +
                "name varchar(255) NOT NULL, " +
                "price double(255) NOT NULL, " +
                "count int(255) NOT NULL," +
                "PRIMARY KEY(userID, itemID));";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO Cart(userID) VALUES" +
                "('3')," +
                "('4');";
        jdbcTemplate.execute(sql);*/
    }
}