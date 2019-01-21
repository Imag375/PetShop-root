package mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataService {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    DataService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    void init(){
        jdbcTemplate.execute("CREATE TABLE Items (Id int PRIMARY KEY auto_increment, Name VARCHAR, Price double, IsPet bit, Age double)");
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