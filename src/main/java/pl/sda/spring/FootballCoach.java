package pl.sda.spring;

public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "run 5k";
    }
}
