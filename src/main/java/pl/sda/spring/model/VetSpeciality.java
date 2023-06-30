package pl.sda.spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class VetSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vet_speciality_id")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    public VetSpeciality(String name) {
        this.name = name;
    }

    public VetSpeciality() {
    }

}
