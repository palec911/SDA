package pl.sda.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MultiplierService multiplier() {
        return new MultiplierService(2);
    }

}