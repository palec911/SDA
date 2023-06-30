package pl.sda.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.spring.model.Vet;
import pl.sda.spring.repositories.VetRepository;

@Service
public class VetService {
    VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public void createVet(Vet vet) {
        vetRepository.save(vet);
    }
    public Vet getVet(Long id) {
        return vetRepository.findById(id).get();
    }
}
