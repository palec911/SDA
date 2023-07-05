package pl.sda.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.sda.spring.model.Owner;
import pl.sda.spring.model.Pet;
import pl.sda.spring.repositories.OwnerRepository;
import pl.sda.spring.repositories.PetRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PetServiceJPA {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public Optional<Pet> getPetById(Long id) {
        return Optional.of(petRepository.findById(id)).orElse(null);
    }

    public Optional<Pet> createPet(Pet pet) {
        return Optional.of(petRepository.save(pet));
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Set<Pet> getPetsByOwnerId(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).get();
        return owner.getPets();
    }

    public void deletePetById(Long petId) {
        petRepository.deleteById(petId);
    }

}
