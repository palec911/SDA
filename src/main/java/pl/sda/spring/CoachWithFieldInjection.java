package pl.sda.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class CoachWithFieldInjection implements CommandLineRunner {

    private Coach coach;

    @Override
    public void run(final String... args) {
        System.out.println(coach.getDailyWorkout());
    }
}