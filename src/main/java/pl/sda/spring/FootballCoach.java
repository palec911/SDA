package pl.sda.spring;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
      return "Football Coach";
    }

    // ...
}