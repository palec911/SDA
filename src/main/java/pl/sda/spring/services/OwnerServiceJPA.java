package pl.sda.spring.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.sda.spring.model.Owner;
import pl.sda.spring.model.Pet;
import pl.sda.spring.repositories.OwnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceJPA {

    OwnerRepository ownerRepository;
    PetServiceJPA petServiceJPA;

    public OwnerServiceJPA(OwnerRepository ownerRepository,
                           PetServiceJPA petServiceJPA) {
        this.ownerRepository = ownerRepository;
        this.petServiceJPA = petServiceJPA;
    }

    @Transactional
    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner getOwnerById(long id) {
        return ownerRepository.findById(id).get();
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }


}
