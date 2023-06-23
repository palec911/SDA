package pl.sda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "HockeyCoach";
    }
}