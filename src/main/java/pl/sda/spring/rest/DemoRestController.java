package pl.sda.spring.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.spring.entity.Student;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello from REST Controller";
    }
}
