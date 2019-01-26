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
        String sql ="CREATE TABLE Cart(" +
                "userID int(36) NOT NULL, " +
                "internalID int(36) PRIMARY KEY NOT NULL, " +
                "itemID int(36) NOT NULL, " +
                "name varchar(255) NOT NULL, " +
                "price double(255) NOT NULL, " +
                "count int(255) NOT NULL)";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO CartItem VALUES" +
                "('3', '1', '1', 'Dog', '1250', '1')," +
                "('2', '2', '2', 'Whiskas', '256', '4')," +
                "('3', '3', '3', 'Fish', '345', '2')," +
                "('1', '4', '4', 'Chappy', '579', '1')," +
                "('2', '5', '5', 'Cat', '750', '1')," +
                "('1', '6', '6', 'Cliffi', '347', '3');";
        jdbcTemplate.execute(sql);

        sql ="CREATE TABLE TotalPrices(" +
                "userID int(36) PRIMARY KEY NOT NULL, " +
                "price double(255) NOT NULL)";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO TotalPrices VALUES" +
                "('2', '926')," +
                "('1', '1006')," +
                "('3', '1595');";
        jdbcTemplate.execute(sql);
    }
}