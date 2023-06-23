package pl.sda.spring;

import org.springframework.boot.CommandLineRunner;

public class CoachWithConstructorInjection implements CommandLineRunner {

    private Coach coach;

    @Override
    public void run(final String... args) {
        System.out.println(coach.getDailyWorkout());
    }
}