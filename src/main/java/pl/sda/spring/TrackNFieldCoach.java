package pl.sda.spring;

import org.springframework.stereotype.Component;

@Component
public class TrackNFieldCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Jump 400 times";
    }
}
