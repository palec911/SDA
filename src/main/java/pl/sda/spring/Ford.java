package pl.sda.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Ford implements Car {

    @Value("${model.ford}")
    private String model;
    @Value("${year.ford}")
    private String productionYear;

    @Override
    public String carOfTheDay() {
        return "Todays car of the day is " + model + " made in " + productionYear;
    }
}
