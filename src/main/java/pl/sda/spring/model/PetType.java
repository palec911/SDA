package pl.sda.spring.model;

import lombok.ToString;

public enum PetType {
    CAT("Cat"), DOG("Dog"), SNAKE("Snake");

    private final String displayName;

    PetType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
