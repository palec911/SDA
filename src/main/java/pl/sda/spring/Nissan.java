package pl.sda.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Nissan implements Car {

    @Value("${model.nissan}")
    private String model;
    @Value("${year.nissan}")
    private String productionYear;

    @Override
    public String carOfTheDay() {
        return "Todays car of the day is " + model + " made in " + productionYear;
    }
}
