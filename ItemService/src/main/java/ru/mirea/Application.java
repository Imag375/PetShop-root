package ru.mirea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        DataService dataService = context.getBean(DataService.class);
        dataService.init();
        System.out.println("DataBase5 run...");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/PetShop-rootDB/ItemDB", "sa", "");
        org.h2.tools.Server.startWebServer(conn);
    }
}
