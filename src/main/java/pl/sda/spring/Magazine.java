package pl.sda.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Magazine {
    private String title;
    private double price;

    public void getMagazineDetails() {
        System.out.println("**Published Magazine Details**");
        System.out.println("Magazine Title        : " + title);
        System.out.println("Magazine price       : " + price);
    }
}
