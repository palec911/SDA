package demo.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Car implements CommandLineRunner {
    private String make = "Ford";
    private int year = 2007;

    @Override
    public void run(String... args) throws Exception {
        log.info("Car make is " + make + " and year of manufacture " + year);
    }
}
