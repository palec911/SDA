package pl.sda.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Coach implements CommandLineRunner {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @Override
    public void run(String... args) throws Exception {
        log.info("Coach name " + coachName + " and his teams name: " + teamName);
    }
}
