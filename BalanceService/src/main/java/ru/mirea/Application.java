package ru.mirea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException{

        SpringApplication.run(Application.class);

        //Connection conn = DriverManager.getConnection("jdbc:h2:~/PetShop-rootDB/BalanceDB", "sa", "");
        //org.h2.tools.Server.startWebServer(conn);
    }
}
