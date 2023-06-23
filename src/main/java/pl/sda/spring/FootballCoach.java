package pl.sda.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run 5k";
    }
}
