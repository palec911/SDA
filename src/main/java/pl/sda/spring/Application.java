package pl.sda.spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

     MultiplierService appService;

    public Application(@Autowired MultiplierService appService) {
        this.appService = appService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(appService.multiply(2));
    }
}
