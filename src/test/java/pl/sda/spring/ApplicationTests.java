package pl.sda.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController();
    }

    @Test
    void sayHello() {
        controller.sayHello();
    }

    @Test
    void contextLoads() {
    }

}
