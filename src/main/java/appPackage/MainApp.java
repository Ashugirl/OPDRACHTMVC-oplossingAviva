package appPackage;

import appPackage.repositories.SpoofDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        new SpoofDataBase();
        SpringApplication.run(MainApp.class, args);

    }
}
