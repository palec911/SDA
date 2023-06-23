package pl.sda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoachWithConstructorInjection implements CommandLineRunner {

    private Coach coach;

    @Autowired
    public CoachWithConstructorInjection(Coach myCoach) {
        coach = myCoach;
    }



    @Override
    public void run(final String... args) throws Exception {
        System.out.println(coach.getDailyWorkout());
    }
}