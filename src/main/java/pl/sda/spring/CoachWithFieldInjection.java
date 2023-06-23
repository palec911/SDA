package pl.sda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoachWithFieldInjection implements CommandLineRunner {

    @Autowired
    private @Qualifier("footballCoach") Coach coach;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(coach.getDailyWorkout());
    }
}
