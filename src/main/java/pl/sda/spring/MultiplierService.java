package pl.sda.spring;

public class MultiplierService {

    private final int multiplier;

    public MultiplierService(int multiplier) {
        this.multiplier = multiplier;
    }

    public int multiply(int value) {
        return value * multiplier;
    }

}