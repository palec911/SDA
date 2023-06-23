package pl.sda.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class FlowControl implements CommandLineRunner {

    private Car car;

    public FlowControl(@Autowired Car car) {
        this.car = car;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(car.carOfTheDay());
    }
}
