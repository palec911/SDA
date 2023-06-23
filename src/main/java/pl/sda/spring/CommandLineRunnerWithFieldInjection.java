package pl.sda.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class CommandLineRunnerWithFieldInjection implements CommandLineRunner {

    private DummyLogger dummyLogger;

    @Override
    public void run(final String... args) throws Exception {
        dummyLogger.sayHello();
    }
}