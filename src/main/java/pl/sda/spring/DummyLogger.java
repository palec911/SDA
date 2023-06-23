package pl.sda.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DummyLogger {

    public void sayHello(final String... args) throws Exception {
        log.info("Hello from DummyLogger");
    }
}