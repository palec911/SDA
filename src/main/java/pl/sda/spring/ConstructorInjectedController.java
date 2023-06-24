package pl.sda.spring;

import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public ConstructorInjectedController() {
        this.greetingService = new GreetingService();
    }

    public void sayHello() {
        this.greetingService.sayHello();
    }
}
