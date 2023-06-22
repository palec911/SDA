package pl.sda.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemo {
    @PostConstruct
    private void postConstruct() {
        System.out.println("I've been initialized");
        // przykłady użycia - inicjalne dane, np utworzenie wpisu w bazie, zalogowanie powstania obiektu
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("I'm being destroyed!");
        // przykłady użycia - zamknięcie połączenia do bazy, otwartego pliku, użycia czegoś 'zewnętrznego'
    }
}
