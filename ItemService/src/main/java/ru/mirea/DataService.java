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
        /*String sql ="CREATE TABLE Item(" +
                "id int(36) PRIMARY KEY NOT NULL, " +
                "name varchar(255) NOT NULL, " +
                "price double(255) NOT NULL, " +
                "count int(255) NOT NULL)";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO Item VALUES" +
                "('1', 'Dog', '1250', '13')," +
                "('2', 'Whiskas', '256', '103')," +
                "('3', 'Fish', '345', '17')," +
                "('4', 'Chappy', '579', '250')," +
                "('5', 'Cat', '750', '25')," +
                "('6', 'Cliffi', '347', '170');";
        jdbcTemplate.execute(sql);

        sql ="CREATE TABLE Pet(" +
                "id int(36) NOT NULL, " +
                "name varchar(255) NOT NULL, " +
                "info varchar(255) NOT NULL," +
                "price double(255) NOT NULL, " +
                "count int(255) NOT NULL, " +
                "FOREIGN KEY(id, name, price, count) REFERENCES Item(id, name, price, count) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "internalID int(36) PRIMARY KEY NOT NULL);";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO Pet VALUES" +
                "('1', 'Dog', 'Big, but cute dog.', '1250', '13', '1')," +
                "('5', 'Cat', 'Playful and fluffy pet.', '750', '25', '2')," +
                "('3', 'Fish', 'Perhaps the fish is magic.', '345', '17', '3');";
        jdbcTemplate.execute(sql);

        sql ="CREATE TABLE Stuff(" +
                "id int(36) NOT NULL, " +
                "name varchar(255) NOT NULL, " +
                "info varchar(255) NOT NULL," +
                "price double(255) NOT NULL, " +
                "count int(255) NOT NULL, " +
                "FOREIGN KEY(id, name, price, count) REFERENCES Item(id, name, price, count) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "internalID int(36) PRIMARY KEY NOT NULL);";
        jdbcTemplate.execute(sql);
        sql = "INSERT INTO Stuff VALUES" +
                "('2', 'Whiskas', 'Dry cat food', '256', '103', '1')," +
                "('4', 'Chappy', 'Dry dog food', '579', '250', '2')," +
                "('6', 'Cliffi', 'Dry fish food', '347', '170', '3');";
        jdbcTemplate.execute(sql);*/
    }
}

//PreparedStatement ps = conn.prepareStatement("CREATE TABLE Items (Id int PRIMARY KEY auto_increment, Name VARCHAR, Price double, IsPet bit, Age double)");
//ps.execute();

//ps = conn.prepareStatement("INSERT INTO Items(Name, Price, IsPet, Age) VALUES ('Haski',100, 1, 2),('Collar', 1, 0, null),('Bulldog',90, 1, 1)");
//ps.execute();

//ps = conn.prepareStatement("CREATE TABLE Users (Id int PRIMARY KEY auto_increment, FirstName varchar, LastName varchar, Password varchar)");
//ps.execute();

//PreparedStatement ps = conn.prepareStatement("INSERT INTO Users(FirstName, LastName, Password) VALUES ('Viktor', 'Lobanov', 'lvv')");
//ps.execute();

//PreparedStatement ps = conn.prepareStatement("CREATE TABLE Carts (Id int PRIMARY KEY auto_increment, UserID int  FOREIGN KEY REFERENCES Users(Id), ItemId int FOREIGN KEY REFERENCES Items(Id))");
//ps.execute();


//PreparedStatement ps = conn.prepareStatement("Insert into Balance (MONEY, USERID) VALUES (300, 1)");
//ps.execute();