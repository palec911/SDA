package pl.sda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoachWithSetterInjection implements CommandLineRunner {

    private Coach coach;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(this.coach.getDailyWorkout());
    }

    @Autowired
    public void setCoach(Coach myCoach) {
        coach = myCoach;
    }
}