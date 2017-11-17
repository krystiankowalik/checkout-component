package com.github.krystiankowalik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication(scanBasePackages = {"com.github.krystiankowalik"})//, exclude = JpaRepositoriesAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        /*try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            //on classpath
        } catch(ClassNotFoundException e) {
            // not on classpath
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

*/
        SpringApplication.run(Application.class, args);
    }

}