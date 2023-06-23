package pl.sda.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketballCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "BasketballCoach";
    }

    // ...
}