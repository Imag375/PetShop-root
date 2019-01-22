package ru.mirea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        DataSource ds = (DataSource) context.getBean("dataSource");
        DataService dataService = new DataService(new JdbcTemplate(ds));
        dataService.init();
        //System.out.println("DataBase5 run...");
        //Connection conn = DriverManager.getConnection("jdbc:h2:~/PetShop-rootDB/ItemDB", "sa", "");
        //org.h2.tools.Server.startWebServer(conn);
    }
}
